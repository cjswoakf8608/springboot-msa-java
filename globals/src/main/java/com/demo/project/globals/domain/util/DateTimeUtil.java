package com.demo.project.globals.domain.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateTimeUtil {

	public static final String DEFAULT_DATETIME_FORMAT = "yyyyMMddHHmmss";

	public static String date2String(Date date, String format){
		return new SimpleDateFormat(format).format(date);
	}
	public static String now(){
		return date2String(new Date(), DEFAULT_DATETIME_FORMAT);
	}

	public static String date2String(LocalDateTime date){
		return date.format(java.time.format.DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT));
	}

}
