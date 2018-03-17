package com.huiyx.framework.log.slf4j;

import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

import com.huiyx.framework.log.Log;

public class Slf4jLocationAwareLog implements Log {
	private LocationAwareLogger logger;

	/**
	 * Following the pattern discussed in pages 162 through 168 of "The complete
	 * log4j manual".
	 */
	final static String FQCN = Slf4jLocationAwareLog.class.getName();

	Slf4jLocationAwareLog(LocationAwareLogger logger){
		this.logger=logger;
	}
	/**
	 * @param marker
	 * @param format
	 * @param arg1
	 * @param arg2
	 * @see org.slf4j.Logger#debug(Marker, String,
	 *      Object, Object)
	 */
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		if (logger.isDebugEnabled(marker)) {
			String msg = MessageFormatter.format(format, arg1, arg2);
			logger.log(marker, FQCN, LocationAwareLogger.DEBUG_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param arg
	 * @see org.slf4j.Logger#debug(Marker, String,
	 *      Object)
	 */
	public void debug(Marker marker, String format, Object arg) {
		if (logger.isDebugEnabled(marker)) {
			String msg = MessageFormatter.format(format, arg);
			logger.log(marker, FQCN, LocationAwareLogger.DEBUG_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param argArray
	 * @see org.slf4j.Logger#debug(Marker, String,
	 *      Object[])
	 */
	public void debug(Marker marker, String format, Object[] argArray) {
		if (logger.isDebugEnabled(marker)) {
			String msg = MessageFormatter.format(format, argArray);
			logger.log(marker, FQCN, LocationAwareLogger.DEBUG_INT, msg, null);
		}

	}

	/**
	 * @param marker
	 * @param msg
	 * @param t
	 * @see org.slf4j.Logger#debug(Marker, String,
	 *      Throwable)
	 */
	public void debug(Marker marker, String msg, Throwable t) {
		if (logger.isDebugEnabled(marker)) {
			logger.log(marker, FQCN, LocationAwareLogger.DEBUG_INT, msg, t);
		}
	}

	/**
	 * @param marker
	 * @param msg
	 * @see org.slf4j.Logger#debug(Marker, String)
	 */
	public void debug(Marker marker, String msg) {
		if (logger.isDebugEnabled(marker)) {
			logger.log(marker, FQCN, LocationAwareLogger.DEBUG_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param arg1
	 * @param arg2
	 * @see org.slf4j.Logger#debug(String, Object,
	 *      Object)
	 */
	public void debug(String format, Object arg1, Object arg2) {
		if (logger.isDebugEnabled()) {
			String msg = MessageFormatter.format(format, arg1, arg2);
			logger.log(null, FQCN, LocationAwareLogger.DEBUG_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param arg
	 * @see org.slf4j.Logger#debug(String, Object)
	 */
	public void debug(String format, Object arg) {
		if (logger.isDebugEnabled()) {
			String msg = MessageFormatter.format(format, arg);
			logger.log(null, FQCN, LocationAwareLogger.DEBUG_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param argArray
	 * @see org.slf4j.Logger#debug(String, Object[])
	 */
	public void debug(String format, Object[] argArray) {
		if (logger.isDebugEnabled()) {
			String msg = MessageFormatter.format(format, argArray);
			logger.log(null, FQCN, LocationAwareLogger.DEBUG_INT, msg, null);
		}
	}

	/**
	 * @param msg
	 * @param t
	 * @see org.slf4j.Logger#debug(String, Throwable)
	 */
	public void debug(String msg, Throwable t) {
		if (logger.isDebugEnabled()) {
			logger.log(null, FQCN, LocationAwareLogger.DEBUG_INT, msg, t);
		}
	}

	/**
	 * @param msg
	 * @see org.slf4j.Logger#debug(String)
	 */
	public void debug(String msg) {
		if (logger.isDebugEnabled()) {
			logger.log(null, FQCN, LocationAwareLogger.DEBUG_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param arg1
	 * @param arg2
	 * @see org.slf4j.Logger#error(Marker, String,
	 *      Object, Object)
	 */
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		if (logger.isErrorEnabled(marker)) {
			String msg = MessageFormatter.format(format, arg1, arg2);
			logger.log(marker, FQCN, LocationAwareLogger.ERROR_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param arg
	 * @see org.slf4j.Logger#error(Marker, String,
	 *      Object)
	 */
	public void error(Marker marker, String format, Object arg) {
		if (logger.isErrorEnabled(marker)) {
			String msg = MessageFormatter.format(format, arg);
			logger.log(marker, FQCN, LocationAwareLogger.ERROR_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param argArray
	 * @see org.slf4j.Logger#error(Marker, String,
	 *      Object[])
	 */
	public void error(Marker marker, String format, Object[] argArray) {
		if (logger.isErrorEnabled(marker)) {
			String msg = MessageFormatter.format(format, argArray);
			logger.log(marker, FQCN, LocationAwareLogger.ERROR_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param msg
	 * @param t
	 * @see org.slf4j.Logger#error(Marker, String,
	 *      Throwable)
	 */
	public void error(Marker marker, String msg, Throwable t) {
		if (logger.isErrorEnabled(marker)) {
			logger.log(marker, FQCN, LocationAwareLogger.ERROR_INT, msg, t);
		}
	}

	/**
	 * @param marker
	 * @param msg
	 * @see org.slf4j.Logger#error(Marker, String)
	 */
	public void error(Marker marker, String msg) {
		if (logger.isErrorEnabled(marker)) {
			logger.log(marker, FQCN, LocationAwareLogger.ERROR_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param arg1
	 * @param arg2
	 * @see org.slf4j.Logger#error(String, Object,
	 *      Object)
	 */
	public void error(String format, Object arg1, Object arg2) {
		if (logger.isErrorEnabled()) {
			String msg = MessageFormatter.format(format, arg1, arg2);
			logger.log(null, FQCN, LocationAwareLogger.ERROR_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param arg
	 * @see org.slf4j.Logger#error(String, Object)
	 */
	public void error(String format, Object arg) {
		if (logger.isErrorEnabled()) {
			String msg = MessageFormatter.format(format, arg);
			logger.log(null, FQCN, LocationAwareLogger.ERROR_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param argArray
	 * @see org.slf4j.Logger#error(String, Object[])
	 */
	public void error(String format, Object[] argArray) {
		if (logger.isErrorEnabled()) {
			String msg = MessageFormatter.format(format, argArray);
			logger.log(null, FQCN, LocationAwareLogger.ERROR_INT, msg, null);
		}
	}

	/**
	 * @param msg
	 * @param t
	 * @see org.slf4j.Logger#error(String, Throwable)
	 */
	public void error(String msg, Throwable t) {
		if (logger.isErrorEnabled()) {
			logger.log(null, FQCN, LocationAwareLogger.ERROR_INT, msg, t);
		}
	}

	/**
	 * @param msg
	 * @see org.slf4j.Logger#error(String)
	 */
	public void error(String msg) {
		if (logger.isErrorEnabled()) {
			logger.log(null, FQCN, LocationAwareLogger.ERROR_INT, msg, null);
		}
	}

	/**
	 * @return String
	 * @see org.slf4j.Logger#getName()
	 */
	public String getName() {
		return logger.getName();
	}

	/**
	 * @param marker
	 * @param format
	 * @param arg1
	 * @param arg2
	 * @see org.slf4j.Logger#info(Marker, String,
	 *      Object, Object)
	 */
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		if (logger.isInfoEnabled(marker)) {
			String msg = MessageFormatter.format(format, arg1, arg2);
			logger.log(marker, FQCN, LocationAwareLogger.INFO_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param arg
	 * @see org.slf4j.Logger#info(Marker, String,
	 *      Object)
	 */
	public void info(Marker marker, String format, Object arg) {
		if (logger.isInfoEnabled(marker)) {
			String msg = MessageFormatter.format(format, arg);
			logger.log(marker, FQCN, LocationAwareLogger.INFO_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param argArray
	 * @see org.slf4j.Logger#info(Marker, String,
	 *      Object[])
	 */
	public void info(Marker marker, String format, Object[] argArray) {
		if (logger.isInfoEnabled(marker)) {
			String msg = MessageFormatter.format(format, argArray);
			logger.log(marker, FQCN, LocationAwareLogger.INFO_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param msg
	 * @param t
	 * @see org.slf4j.Logger#info(Marker, String,
	 *      Throwable)
	 */
	public void info(Marker marker, String msg, Throwable t) {
		if (logger.isInfoEnabled(marker)) {
			logger.log(marker, FQCN, LocationAwareLogger.INFO_INT, msg, t);
		}
	}

	/**
	 * @param marker
	 * @param msg
	 * @see org.slf4j.Logger#info(Marker, String)
	 */
	public void info(Marker marker, String msg) {
		if (logger.isInfoEnabled(marker)) {
			logger.log(marker, FQCN, LocationAwareLogger.INFO_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param arg1
	 * @param arg2
	 * @see org.slf4j.Logger#info(String, Object,
	 *      Object)
	 */
	public void info(String format, Object arg1, Object arg2) {
		if (logger.isInfoEnabled()) {
			String msg = MessageFormatter.format(format, arg1, arg2);
			logger.log(null, FQCN, LocationAwareLogger.INFO_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param arg
	 * @see org.slf4j.Logger#info(String, Object)
	 */
	public void info(String format, Object arg) {
		if (logger.isInfoEnabled()) {
			String msg = MessageFormatter.format(format, arg);
			logger.log(null, FQCN, LocationAwareLogger.INFO_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param argArray
	 * @see org.slf4j.Logger#info(String, Object[])
	 */
	public void info(String format, Object[] argArray) {
		if (logger.isInfoEnabled()) {
			String msg = MessageFormatter.format(format, argArray);
			logger.log(null, FQCN, LocationAwareLogger.INFO_INT, msg, null);
		}
	}

	/**
	 * @param msg
	 * @param t
	 * @see org.slf4j.Logger#info(String, Throwable)
	 */
	public void info(String msg, Throwable t) {
		if (logger.isInfoEnabled()) {
			logger.log(null, FQCN, LocationAwareLogger.INFO_INT, msg, t);
		}
	}

	/**
	 * @param msg
	 * @see org.slf4j.Logger#info(String)
	 */
	public void info(String msg) {
		if (logger.isInfoEnabled()) {
			logger.log(null, FQCN, LocationAwareLogger.INFO_INT, msg, null);
		}
	}

	/**
	 * @return boolean
	 * @see org.slf4j.Logger#isDebugEnabled()
	 */
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	/**
	 * @param marker
	 * @return boolean
	 * @see org.slf4j.Logger#isDebugEnabled(Marker)
	 */
	public boolean isDebugEnabled(Marker marker) {
		return logger.isDebugEnabled(marker);
	}

	/**
	 * @return boolean
	 * @see org.slf4j.Logger#isErrorEnabled()
	 */
	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}

	/**
	 * @param marker
	 * @return boolean
	 * @see org.slf4j.Logger#isErrorEnabled(Marker)
	 */
	public boolean isErrorEnabled(Marker marker) {
		return logger.isErrorEnabled(marker);
	}

	/**
	 * @return boolean
	 * @see org.slf4j.Logger#isInfoEnabled()
	 */
	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	/**
	 * @param marker
	 * @return boolean
	 * @see org.slf4j.Logger#isInfoEnabled(Marker)
	 */
	public boolean isInfoEnabled(Marker marker) {
		return logger.isInfoEnabled(marker);
	}

	/**
	 * @return boolean
	 * @see org.slf4j.Logger#isTraceEnabled()
	 */
	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	/**
	 * @param marker
	 * @return boolean
	 * @see org.slf4j.Logger#isTraceEnabled(Marker)
	 */
	public boolean isTraceEnabled(Marker marker) {
		return logger.isTraceEnabled(marker);
	}

	/**
	 * @return boolean
	 * @see org.slf4j.Logger#isWarnEnabled()
	 */
	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	/**
	 * @param marker
	 * @return boolean
	 * @see org.slf4j.Logger#isWarnEnabled(Marker)
	 */
	public boolean isWarnEnabled(Marker marker) {
		return logger.isWarnEnabled(marker);
	}

	/**
	 * @param marker
	 * @param format
	 * @param arg1
	 * @param arg2
	 * @see org.slf4j.Logger#trace(Marker, String,
	 *      Object, Object)
	 */
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		if (logger.isTraceEnabled(marker)) {
			String msg = MessageFormatter.format(format, arg1, arg2);
			logger.log(marker, FQCN, LocationAwareLogger.TRACE_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param arg
	 * @see org.slf4j.Logger#trace(Marker, String,
	 *      Object)
	 */
	public void trace(Marker marker, String format, Object arg) {
		if (logger.isTraceEnabled(marker)) {
			String msg = MessageFormatter.format(format, arg);
			logger.log(marker, FQCN, LocationAwareLogger.TRACE_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param argArray
	 * @see org.slf4j.Logger#trace(Marker, String,
	 *      Object[])
	 */
	public void trace(Marker marker, String format, Object[] argArray) {
		if (logger.isTraceEnabled(marker)) {
			String msg = MessageFormatter.format(format, argArray);
			logger.log(marker, FQCN, LocationAwareLogger.TRACE_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param msg
	 * @param t
	 * @see org.slf4j.Logger#trace(Marker, String,
	 *      Throwable)
	 */
	public void trace(Marker marker, String msg, Throwable t) {
		if (logger.isTraceEnabled(marker)) {
			logger.log(marker, FQCN, LocationAwareLogger.TRACE_INT, msg, t);
		}
	}

	/**
	 * @param marker
	 * @param msg
	 * @see org.slf4j.Logger#trace(Marker, String)
	 */
	public void trace(Marker marker, String msg) {
		if (logger.isTraceEnabled(marker)) {
			logger.log(marker, FQCN, LocationAwareLogger.TRACE_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param arg1
	 * @param arg2
	 * @see org.slf4j.Logger#trace(String, Object,
	 *      Object)
	 */
	public void trace(String format, Object arg1, Object arg2) {
		if (logger.isTraceEnabled()) {
			String msg = MessageFormatter.format(format, arg1, arg2);
			logger.log(null, FQCN, LocationAwareLogger.TRACE_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param arg
	 * @see org.slf4j.Logger#trace(String, Object)
	 */
	public void trace(String format, Object arg) {
		if (logger.isTraceEnabled()) {
			String msg = MessageFormatter.format(format, arg);
			logger.log(null, FQCN, LocationAwareLogger.TRACE_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param argArray
	 * @see org.slf4j.Logger#trace(String, Object[])
	 */
	public void trace(String format, Object[] argArray) {
		if (logger.isTraceEnabled()) {
			String msg = MessageFormatter.format(format, argArray);
			logger.log(null, FQCN, LocationAwareLogger.TRACE_INT, msg, null);
		}
	}

	/**
	 * @param msg
	 * @param t
	 * @see org.slf4j.Logger#trace(String, Throwable)
	 */
	public void trace(String msg, Throwable t) {
		if (logger.isTraceEnabled()) {
			logger.log(null, FQCN, LocationAwareLogger.TRACE_INT, msg, t);
		}
	}

	/**
	 * @param msg
	 * @see org.slf4j.Logger#trace(String)
	 */
	public void trace(String msg) {
		if (logger.isTraceEnabled()) {
			logger.log(null, FQCN, LocationAwareLogger.TRACE_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param arg1
	 * @param arg2
	 * @see org.slf4j.Logger#warn(Marker, String,
	 *      Object, Object)
	 */
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		if (logger.isWarnEnabled(marker)) {
			String msg = MessageFormatter.format(format, arg1, arg2);
			logger.log(marker, FQCN, LocationAwareLogger.WARN_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param arg
	 * @see org.slf4j.Logger#warn(Marker, String,
	 *      Object)
	 */
	public void warn(Marker marker, String format, Object arg) {
		if (logger.isWarnEnabled(marker)) {
			String msg = MessageFormatter.format(format, arg);
			logger.log(marker, FQCN, LocationAwareLogger.WARN_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param format
	 * @param argArray
	 * @see org.slf4j.Logger#warn(Marker, String,
	 *      Object[])
	 */
	public void warn(Marker marker, String format, Object[] argArray) {
		if (logger.isWarnEnabled(marker)) {
			String msg = MessageFormatter.format(format, argArray);
			logger.log(marker, FQCN, LocationAwareLogger.WARN_INT, msg, null);
		}
	}

	/**
	 * @param marker
	 * @param msg
	 * @param t
	 * @see org.slf4j.Logger#warn(Marker, String,
	 *      Throwable)
	 */
	public void warn(Marker marker, String msg, Throwable t) {
		if (logger.isWarnEnabled(marker)) {
			logger.log(marker, FQCN, LocationAwareLogger.WARN_INT, msg, t);
		}
	}

	/**
	 * @param marker
	 * @param msg
	 * @see org.slf4j.Logger#warn(Marker, String)
	 */
	public void warn(Marker marker, String msg) {
		if (logger.isWarnEnabled(marker)) {
			logger.log(marker, FQCN, LocationAwareLogger.WARN_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param arg1
	 * @param arg2
	 * @see org.slf4j.Logger#warn(String, Object,
	 *      Object)
	 */
	public void warn(String format, Object arg1, Object arg2) {
		if (logger.isWarnEnabled()) {
			String msg = MessageFormatter.format(format, arg1, arg2);
			logger.log(null, FQCN, LocationAwareLogger.WARN_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param arg
	 * @see org.slf4j.Logger#warn(String, Object)
	 */
	public void warn(String format, Object arg) {
		if (logger.isWarnEnabled()) {
			String msg = MessageFormatter.format(format, arg);
			logger.log(null, FQCN, LocationAwareLogger.WARN_INT, msg, null);
		}
	}

	/**
	 * @param format
	 * @param argArray
	 * @see org.slf4j.Logger#warn(String, Object[])
	 */
	public void warn(String format, Object[] argArray) {
		if (logger.isWarnEnabled()) {
			String msg = MessageFormatter.format(format, argArray);
			logger.log(null, FQCN, LocationAwareLogger.WARN_INT, msg, null);
		}
	}

	/**
	 * @param msg
	 * @param t
	 * @see org.slf4j.Logger#warn(String, Throwable)
	 */
	public void warn(String msg, Throwable t) {
		if (logger.isWarnEnabled()) {
			logger.log(null, FQCN, LocationAwareLogger.WARN_INT, msg, t);
		}
	}

	/**
	 * @param msg
	 * @see org.slf4j.Logger#warn(String)
	 */
	public void warn(String msg) {
		if (logger.isWarnEnabled()) {
			logger.log(null, FQCN, LocationAwareLogger.WARN_INT, msg, null);
		}
	}

}
