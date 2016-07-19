package logger;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SELENIUMLogger {
static Logger m_logger = null;
	
	public static enum LogLevel{
		DEBUG,
		INFO,
		WARN,
		ERROR,
		FATAL
	}

	public static void Configure(){
		m_logger = LogManager.getLogger();
	}
	
	public static void Log(String message){
		Log(message, LogLevel.INFO);
	}
	
	public static void Log(String message, LogLevel level){
		switch(level) {
			case DEBUG:
				m_logger.debug(message);
				break;
			case INFO :
				m_logger.info(message);
				break;
			case WARN:
				m_logger.warn(message);
				break;
			case ERROR:
				m_logger.error(message);
				break;
			case FATAL:
				m_logger.fatal(message);
				break;
		}
	}
}
