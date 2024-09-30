package com.demo.project.coreusers.presentation.response;

import com.demo.project.coreusers.presentation.response.base.BaseApiException;
import com.demo.project.coreusers.presentation.response.base.BaseApiResponse;
import com.demo.project.globals.domain.constant.ResponseConstant;
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
