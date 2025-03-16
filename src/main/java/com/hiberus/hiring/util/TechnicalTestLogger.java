package com.hiberus.hiring.util;

import java.io.Serializable;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

/**
 * Clase para logger
 */
public class TechnicalTestLogger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private static final Logger LOG_MONITORING = Logger.getLogger("com.hiberus.hiring.util");
	
	public static void writeLogInfo(String msg) {
		try {
			Handler consoleHandler = new ConsoleHandler();
			LOG_MONITORING.addHandler(consoleHandler);
			LOG_MONITORING.log(Level.INFO, msg);
			consoleHandler.close();
		}catch(Exception e) {
			LOG_MONITORING.log(Level.SEVERE, e.getMessage());
		}
	}
	
	public static void writeLogError(String msg) {
		try {
			Handler consoleHandler = new ConsoleHandler();
			LOG_MONITORING.addHandler(consoleHandler);
			LOG_MONITORING.log(Level.SEVERE, msg);
			consoleHandler.close();
		}catch(Exception e) {
			LOG_MONITORING.log(Level.SEVERE, e.getMessage());
		}
	}
}
