package com.huiyx.framework.log.slf4j;

import org.slf4j.Logger;

import com.huiyx.framework.log.Log;

public class Slf4jLog implements Log
{
	private Logger logger;

	Slf4jLog(Logger logger)
	{
		this.logger = logger;
	}

	@Override
	public void debug(String format, Object arg1, Object arg2)
	{
		logger.debug(format, arg1, arg2);

	}

	@Override
	public void debug(String format, Object arg)
	{
		logger.debug(format, arg);

	}

	@Override
	public void debug(String format, Object[] argArray)
	{
		logger.debug(format, argArray);

	}

	@Override
	public void debug(String msg, Throwable t)
	{
		logger.debug(msg, t);

	}

	@Override
	public void debug(String msg)
	{
		logger.debug(msg);

	}

	@Override
	public void error(String format, Object arg1, Object arg2)
	{
		logger.error(format, arg1, arg2);

	}

	@Override
	public void error(String format, Object arg)
	{
		logger.error(format, arg);

	}

	@Override
	public void error(String format, Object[] argArray)
	{
		logger.error(format, argArray);

	}

	@Override
	public void error(String msg, Throwable t)
	{
		logger.error(msg, t);

	}

	@Override
	public void error(String msg)
	{
		logger.error(msg);

	}

	@Override
	public String getName()
	{
		return logger.getName();
	}

	@Override
	public void info(String format, Object arg1, Object arg2)
	{
		logger.info(format, arg1, arg2);
	}

	@Override
	public void info(String format, Object arg)
	{
		logger.info(format, arg);
	}

	@Override
	public void info(String format, Object[] argArray)
	{
		logger.info(format, argArray);

	}

	@Override
	public void info(String msg, Throwable t)
	{
		logger.info(msg, t);

	}

	@Override
	public void info(String msg)
	{
		logger.info(msg);
	}

	@Override
	public boolean isDebugEnabled()
	{
		return logger.isDebugEnabled();
	}

	@Override
	public boolean isErrorEnabled()
	{
		return logger.isErrorEnabled();
	}

	@Override
	public boolean isInfoEnabled()
	{
		return logger.isInfoEnabled();
	}

	@Override
	public boolean isTraceEnabled()
	{
		return logger.isTraceEnabled();
	}

	@Override
	public boolean isWarnEnabled()
	{
		return logger.isWarnEnabled();
	}

	@Override
	public void trace(String format, Object arg1, Object arg2)
	{
		logger.trace(format, arg1, arg2);

	}

	@Override
	public void trace(String format, Object arg)
	{
		logger.trace(format, arg);

	}

	@Override
	public void trace(String format, Object[] argArray)
	{
		logger.trace(format, argArray);
	}

	@Override
	public void trace(String msg, Throwable t)
	{
		logger.trace(msg, t);
	}

	@Override
	public void trace(String msg)
	{
		logger.trace(msg);

	}

	@Override
	public void warn(String format, Object arg1, Object arg2)
	{
		logger.warn(format, arg1, arg2);

	}

	@Override
	public void warn(String format, Object arg)
	{
		logger.warn(format, arg);
	}

	@Override
	public void warn(String format, Object[] argArray)
	{
		logger.warn(format, argArray);
	}

	@Override
	public void warn(String msg, Throwable t)
	{
		logger.warn(msg, t);
	}

	@Override
	public void warn(String msg)
	{
		logger.warn(msg);
	}

}
