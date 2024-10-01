package com.demo.project.payments.domain.util;

import com.demo.project.globals.domain.constant.ResponseConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
public class MessageUtil {
	private static MessageSourceAccessor messageSource = null;

	@Autowired
    public void setMessageSourceAccessor(@Qualifier("BusinessMessageSource")MessageSourceAccessor messageSource) {
        MessageUtil.messageSource = messageSource;
    }

    public static String getMessage(String code) {
        return getMessage(code, null, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String code, Object[] objs) {
        return getMessage(code, objs, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String code, Object[] objs, Locale locale) {
        return messageSource.getMessage(code, objs, locale);
    }

    public static String getDbCodeName(String table, String column, String code) {
        String messageCodeName = ResponseConstant.API_RESULT_MSG_CODE_NAME_PREFIX + table + "." + column + "." + code;
        return getMessage( messageCodeName, null, LocaleContextHolder.getLocale());
    }
}
