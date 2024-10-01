package com.demo.project.payments.infrastructure.configuration;

import com.demo.project.payments.presentation.response.base.BaseApiException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentFeignErrorDecoder implements ErrorDecoder {

    @SneakyThrows
    @Override
    public Exception decode(final String methodKey, Response response) {
        return new BaseApiException(response.status(), response.reason());
    }
}
