package com.demo.project.apps.infrastructure.configuration;

import com.demo.project.apps.presentation.response.base.BaseApiException;
import com.demo.project.apps.presentation.response.base.BaseApiResponse;
import com.demo.project.globals.domain.constant.ResponseConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    private final ObjectMapper objectMapper;

    public FeignErrorDecoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @Override
    public Exception decode(final String methodKey, Response response) {
        try (InputStream body = response.body().asInputStream()) {
            BaseApiResponse message = objectMapper.readValue(body, BaseApiResponse.class);
            return new BaseApiException(message.getCode(), message.getMessage());
        } catch (IOException e) {
            throw new BaseApiException(ResponseConstant.API_HTTP_BAD_REQUEST, "Unknown error occurred");
        }
    }
}
