package com.huiyx.framework.log.slf4j;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

import com.huiyx.framework.log.ILogFactory;
import com.huiyx.framework.log.Log;

public class Slf4jLogFactory implements ILogFactory{
	Map loggerMap ;

	public Slf4jLogFactory(){	
		loggerMap = new HashMap();
	}
	
	
	public Log getLog(String name) {
	    Log instance = null;
	    // protect against concurrent access of loggerMap
	    synchronized (this) {
	      instance = (Log) loggerMap.get(name);
	      if (instance == null) {
	        Logger logger = LoggerFactory.getLogger(name);
	        if(logger instanceof LocationAwareLogger) {
	          instance = new Slf4jLocationAwareLog((LocationAwareLogger) logger);
	        } else {
	          instance = new Slf4jLog(logger);
	        }
	        loggerMap.put(name, instance);
	      }
	    }
		
		return instance;
	}
}
