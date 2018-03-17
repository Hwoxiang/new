package com.huiyx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils
{

	//进行日期转化
	public static String toString(Date date)
	{
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}

	public static String getDataString()
	{
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sf.format(new Date());
	}

}
