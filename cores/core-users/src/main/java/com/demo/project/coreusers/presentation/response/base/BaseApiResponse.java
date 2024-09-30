package com.demo.project.coreusers.presentation.response.base;

import com.demo.project.globals.domain.enumeration.ResponseApiStatus;
import com.demo.project.globals.domain.util.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class BaseApiResponse<T> {
	private final int code;
	private String message;
	private String now;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;

	public static <T> BaseApiResponse<T> success() {
		return success(null);
	}

	public static <T> BaseApiResponse<T> success(T result) {
		return response(ResponseApiStatus.OK.getStatus(), "Success", result);
	}

	public static <T> BaseApiResponse<T> error(BaseApiException e, String message) {
		return response(e.getCode(), message, null);
	}

	public static <T> BaseApiResponse<T> error(int code, String message) {
		return response(code, message, null);
	}

	private static <T> BaseApiResponse<T> response(int code, String message, T result) {
		return new BaseApiResponse<>(code, message, DateTimeUtil.now(), result);
	}
}
