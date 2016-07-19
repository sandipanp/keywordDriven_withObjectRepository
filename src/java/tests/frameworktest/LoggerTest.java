package frameworktest;

import org.testng.annotations.Test;

import drivers.StartWedDriver;
import logger.SELENIUMLogger;

public class LoggerTest extends StartWedDriver{

	@Test
	public void testLog(){
		SELENIUMLogger.Log("Successful Logging");
	}
}
