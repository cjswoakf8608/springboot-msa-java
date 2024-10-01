package com.demo.project.workers.domain.aspects;

import com.demo.project.workers.domain.annotations.DistributeLock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class DistributeLockAspect {
    private static final String REDISSON_KEY_PREFIX = "LOCK";
    private final RedissonClient redissonClient;

    // 읽기 작업은 lock을 획득하지 않고 쓰기 작업만 lock을 획득
    @Around("@annotation(distributeLock)")
    @Transactional
    public Object lock(ProceedingJoinPoint joinPoint, DistributeLock distributeLock) throws Throwable {
        String key = generateKey(joinPoint, distributeLock);
        RLock lock = redissonClient.getLock(key);

        try {
            boolean isLocked = lock.tryLock(distributeLock.waitTime(), distributeLock.leaseTime(), distributeLock.timeUnit());
            if (!isLocked) {
                throw new Exception("Failed lock > key: " + key);
            }

            return joinPoint.proceed();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    private String generateKey(ProceedingJoinPoint joinPoint, DistributeLock distributeLock) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String dynamicValue = parseDynamicValue(signature, joinPoint.getArgs(), distributeLock.key());
        return String.join("_", REDISSON_KEY_PREFIX, distributeLock.prefix(), dynamicValue);
    }

    private String parseDynamicValue(MethodSignature signature, Object[] args, String key) {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        String[] paramNames = signature.getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            context.setVariable(paramNames[i], args[i]);
        }

        return parser.parseExpression(key).getValue(context, String.class);
    }
}
