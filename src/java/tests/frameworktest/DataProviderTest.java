package frameworktest;


import org.testng.annotations.Test;

import drivers.StartWedDriver;
import logger.SELENIUMLogger;

public class DataProviderTest extends StartWedDriver{
	
	@Test(dataProvider="dataProvider")
	public void testSuccessfulLogin(String username, String password){
		SELENIUMLogger.Log("testSuccessfulLogin  Started");
		System.out.println("UserName => " + username + ", Password => " + password);
		SELENIUMLogger.Log("testSuccessfulLogin  Completed");
	}
	
	@Test(dataProvider="dataProvider")
	public void testApplyingSortOrder(String sortOrder){
		SELENIUMLogger.Log("testApplyingSortOrder  Started");
		System.out.println("Sort Order => " + sortOrder);
		SELENIUMLogger.Log("testApplyingSortOrder  Completed");
	}

}
