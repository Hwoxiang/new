package com.huiyx.framework.log;

public interface Log
{
	public void debug(String format, Object arg1, Object arg2);

	public void debug(String format, Object arg);

	public void debug(String format, Object[] argArray);

	public void debug(String msg, Throwable t);

	public void debug(String msg);

	public void error(String format, Object arg1, Object arg2);

	public void error(String format, Object arg);

	public void error(String format, Object[] argArray);

	public void error(String msg, Throwable t);

	public void error(String msg);

	public String getName();

	public void info(String format, Object arg1, Object arg2);

	public void info(String format, Object arg);

	public void info(String format, Object[] argArray);

	public void info(String msg, Throwable t);

	public void info(String msg);

	public boolean isDebugEnabled();

	public boolean isErrorEnabled();

	public boolean isInfoEnabled();

	public boolean isTraceEnabled();

	public boolean isWarnEnabled();

	public void trace(String format, Object arg1, Object arg2);

	public void trace(String format, Object arg);

	public void trace(String format, Object[] argArray);

	public void trace(String msg, Throwable t);

	public void trace(String msg);

	public void warn(String format, Object arg1, Object arg2);

	public void warn(String format, Object arg);

	public void warn(String format, Object[] argArray);

	public void warn(String msg, Throwable t);

	public void warn(String msg);

}
