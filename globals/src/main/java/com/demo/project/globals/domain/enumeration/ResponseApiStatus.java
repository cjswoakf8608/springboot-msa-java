package com.demo.project.globals.domain.enumeration;

import com.demo.project.globals.domain.constant.ResponseConstant;
import lombok.Getter;

@Getter
public enum ResponseApiStatus {
    OK(ResponseConstant.API_HTTP_OK),
    BAD_REQUEST(ResponseConstant.API_HTTP_BAD_REQUEST),
    UNAUTHORIZED(ResponseConstant.API_HTTP_UNAUTHORIZED),
    FORBIDDEN(ResponseConstant.API_HTTP_FORBIDDEN),
    NOT_FOUND(ResponseConstant.API_HTTP_NOT_FOUND),
    INTERNAL_SERVER_ERROR(ResponseConstant.API_HTTP_SERVER_ERROR);

    private final int status;

    ResponseApiStatus(int status) {
        this.status = status;
    }

}
