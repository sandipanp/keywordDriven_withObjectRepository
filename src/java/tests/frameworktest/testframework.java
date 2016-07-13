package frameworktest;



import org.testng.annotations.Test;

import drivers.StartWedDriver;
import functionalibrary.LoginLogout;
import functionalibrary.Navigation;
import helpers.ActionHelper;
import helpers.ButtonHelper;
import helpers.ComboboxHelper;
import helpers.LinkHelper;
import helpers.TextBoxHelper;
import helpers.VerificationHelper;

public class testframework extends StartWedDriver {

	@Test(enabled=true)
	public void Test1() throws Exception{
		//driver.findElement(objectRepo.getLocator("leathershop.homepage.signinlink")).click();
		LinkHelper.clickLink(objectRepo.getLocator("leathershop.homepage.signinlink"));
		System.out.println("In text 1");
	}
	@Test(enabled=true)
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
		VerificationHelper.verifyExactText("Sandipan Pramanik", objectRepo.getLocator("leathershop.myaccountpage.displayedusename"));
	}
	
	@Test(enabled=true)
	public void Test3() {
		System.out.println("In test 3");
	}
	
	@Test(enabled=true)
	public void LoginTest()  {
		LoginLogout.loginToSite(configProp.getUsername(), configProp.getPassword());
		LoginLogout.logoutFromSite();
	}
	
	@Test(enabled=true)
	public void CanGoToMenFormalShoePage() throws InterruptedException{
		// First log in to site
		LoginLogout.loginToSite(configProp.getUsername(), configProp.getPassword());
		// Move on Menu Option :  Men
		ActionHelper.moveToElement(objectRepo.getLocator("leathershop.menu.men"));
		
		// Move to sub menu Click on SubMenu Option : Formal
		ActionHelper.moveToElementAndClick(objectRepo.getLocator("leathershop.men.submenu.formal"));
		
		// Verify you are on formal page
		VerificationHelper.verifyTextContains(objectRepo.getLocator("leathershop.men.formalshoepage.formaltext"), "FORMAL");
		
		// Log out from site
		LoginLogout.logoutFromSite();
		
		/*Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(objectRepo.getLocator("leathershop.menu.men")))
			.build().perform();
		Thread.sleep(3);
		// Click on SubMenu Option : Formal
		new Actions(driver).moveToElement(driver.findElement(objectRepo.getLocator("leathershop.men.submenu.formal")))
		.click()
		.build()
		.perform();
		
		// Waiting for formal text to appear
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(objectRepo.getLocator("leathershop.men.formalshoepage.formaltext")));
		// Verify you are on formal page
		boolean result = driver.findElement(objectRepo.getLocator("leathershop.men.formalshoepage.formaltext")).getText().contains("FORMAL");
		Assert.assertTrue(result, "Not at formal shoe page");
		*/
		
	}
	
	@Test(enabled=true)
	public void sortingFormalShoes(){
		// First log in to site
		LoginLogout.loginToSite(configProp.getUsername(), configProp.getPassword());
		// Move to formal shoe page
		Navigation.moveToMensFormalShoePage();
		//Select option
		ComboboxHelper.selectComboOption(objectRepo.getLocator("leathershop.men.formalshoepage.sortDropDown"), "Price: Lowest first");
		
		// Verify combo selection
		VerificationHelper.verifyComboSelection(objectRepo.getLocator("leathershop.men.formalshoepage.sortDropDown"), "Price: Lowest first");
	}
}
