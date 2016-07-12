package frameworktest;


import org.testng.annotations.Test;

import drivers.StartWedDriver;
import helpers.ButtonHelper;
import helpers.LinkHelper;
import helpers.TextBoxHelper;
import helpers.VerificationHelper;

public class testframework extends StartWedDriver {

	@Test(priority=1)
	public void Test1() throws Exception{
		//driver.findElement(objectRepo.getLocator("leathershop.homepage.signinlink")).click();
		LinkHelper.clickLink(objectRepo.getLocator("leathershop.homepage.signinlink"));
		System.out.println("In text 1");
	}
	@Test(priority = 2)
	public void Test2() throws Exception{
		//Click Sign in link in home page
		LinkHelper.clickLink(objectRepo.getLocator("leathershop.homepage.signinlink"));
		
		// Put username
		TextBoxHelper.enterText(objectRepo.getLocator("leathershop.signinpage.username"), "sandipan.mca@gmail.com");
		
		//put password
		TextBoxHelper.enterText(objectRepo.getLocator("leathershop.signinpage.password"), "Password1");
		Thread.sleep(10);
		//Click button
		ButtonHelper.clickButton(objectRepo.getLocator("leathershop.signinpage.signinbutton"));
		
		//Verify log in
		VerificationHelper.verifyText("Sandipan Pramanik", objectRepo.getLocator("leathershop.myaccountpage.displayedusename"));
	}
	
	@Test(priority = 3)
	public void Test3() {
		System.out.println("In test 3");
	}
}
