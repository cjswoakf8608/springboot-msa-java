package com.demo.project.payments.infrastructure.integration;


import com.demo.project.globals.domain.constant.ResponseConstant;
import com.demo.project.payments.presentation.response.base.BaseApiException;
import com.demo.project.payments.presentation.response.base.BaseApiResponse;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {
    private final MessageSourceAccessor messageSource;

    public ApiControllerAdvice(@Qualifier("BusinessMessageSource") MessageSourceAccessor messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Customer API Exception Handler
     */
    @ExceptionHandler(BaseApiException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public BaseApiResponse<Object> handleApiException(BaseApiException e) {
        if (BooleanUtils.isFalse(StringUtils.isEmpty(e.getMessage()))) {
            return BaseApiResponse.error(e, e.getMessage());
        }

        String message = messageSource.getMessage(ResponseConstant.API_RESULT_MSG_PREFIX + e.getCode());
        return BaseApiResponse.error(e, message);
    }

    /**
     * Exception Handler
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseApiResponse<Object> handleApiException(Exception e) {
        e.printStackTrace();
        return BaseApiResponse.error(
                new BaseApiException(ResponseConstant.API_HTTP_SERVER_ERROR),
                e.getMessage()
        );
    }
}
