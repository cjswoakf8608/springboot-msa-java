package com.demo.project.apps.presentation.response.base;

import com.demo.project.apps.domain.util.MessageUtil;
import com.demo.project.globals.domain.constant.ResponseConstant;
import com.demo.project.globals.domain.util.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseApiException extends RuntimeException {

	private Integer code;
	private String message;
	private String now;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object data;

	public BaseApiException(Integer code) {
		this.code = code;
		this.message = MessageUtil.getMessage(ResponseConstant.API_RESULT_MSG_PREFIX + code);
		this.now = DateTimeUtil.now();
	}

	public BaseApiException(Integer code, String message) {
		this.code = code;
		this.message = message;
		this.now = DateTimeUtil.now();
	}

	public BaseApiException(Integer code, Object data) {
		this.code = code;
		this.message = MessageUtil.getMessage(ResponseConstant.API_RESULT_MSG_PREFIX + code);
		this.now = DateTimeUtil.now();
		this.data = data;
	}

}
