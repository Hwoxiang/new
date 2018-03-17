package com.huiyx.framework.log;

import com.huiyx.framework.log.slf4j.Slf4jLogFactory;


/**
 * 用于产生Log实现 使用说明：
 * 
 * <pre>private final static Log log = LogFactory.getLog(XXXX.class);
 * 
 * <pre>
 * XXXX代表需要输出日志的类
 * 
 */
public final class LogFactory {
	// 固定通过Slf4jLogFactory实现
	private static ILogFactory factory = new Slf4jLogFactory();

	/**
	 * 通过名称获取日志类
	 * 
	 * @param name
	 *            String
	 * @return Log
	 */
	public static Log getLog(String name) {
		return factory.getLog(name);
	}

	/**
	 * 通过类名获取日志类
	 * 
	 * @param clazz
	 *            Class
	 * @return Log
	 */
	public static Log getLog(Class clazz) {
		return factory.getLog(clazz.getName());
	}
}
