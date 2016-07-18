package frameworktest;

import org.testng.annotations.Test;

import drivers.StartWedDriver;

public class DataProviderTest extends StartWedDriver{
	
	@Test(dataProvider="dataProvider")
	public void testSuccessfulLogin(String username, String password){
		System.out.println("UserName => " + username + ", Password => " + password);
	}
	
	@Test(dataProvider="dataProvider")
	public void testApplyingSortOrder(String sortOrder){
		System.out.println("Sort Order => " + sortOrder);
	}

}
