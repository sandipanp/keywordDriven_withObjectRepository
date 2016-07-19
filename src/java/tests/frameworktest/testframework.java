package frameworktest;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import logger.SELENIUMLogger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class testframework extends StartWedDriver {

	@Test(enabled=true)
	public void Test1() throws Exception{
		SELENIUMLogger.Log("Test1  Started");
		//driver.findElement(objectRepo.getLocator("leathershop.homepage.signinlink")).click();
		LinkHelper.clickLink(objectRepo.getLocator("leathershop.homepage.signinlink"));
		SELENIUMLogger.Log("Test1  Completed");
	}
	@Test(enabled=true)
	public void Test2() throws Exception{
		SELENIUMLogger.Log("Test2  Started");
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
		SELENIUMLogger.Log("Test2  Completed");
	}
	
	@Test(enabled=true)
	public void Test3() {
		SELENIUMLogger.Log("Test3  Started");
		System.out.println("In test 3");
		SELENIUMLogger.Log("Test3  Completed");
	}
	
	@Test(enabled=true)
	public void LoginTest()  {
		SELENIUMLogger.Log("LoginTest  Started");
		LoginLogout.loginToSite(configProp.getUsername(), configProp.getPassword());
		LoginLogout.logoutFromSite();
		SELENIUMLogger.Log("LoginTest  Completed");
	}
	
	@Test(enabled=true)
	public void CanGoToMenFormalShoePage() throws InterruptedException{
		SELENIUMLogger.Log("CanGoToMenFormalShoePage  Started");
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
		SELENIUMLogger.Log("CanGoToMenFormalShoePage  Completed");
	}
	
	@Test(enabled=false)
	public void sortingFormalShoes() throws InterruptedException{
		/*
		// First log in to site
		LoginLogout.loginToSite(configProp.getUsername(), configProp.getPassword());
		// Move to formal shoe page
		Navigation.moveToMensFormalShoePage();
		//Select option
		ComboboxHelper.selectComboOption(objectRepo.getLocator("leathershop.men.formalshoepage.sortDropDown"), "Price: Lowest first");
		
		// Verify combo selection
		VerificationHelper.verifyComboSelection(objectRepo.getLocator("leathershop.men.formalshoepage.sortDropDown"), "Price: Lowest first");
		
		String[] price=null;
		
		
		WebElement ul = driver.findElement(By.xpath("//div[@id='center_column']/ul"));
		List<WebElement> lis = ul.findElements(By.tagName("li"));
		
		for(int count = 0; count < lis.size(); count++){
			Thread.sleep(2);
			price[count] = lis.get(count).findElement(By.xpath("//div[@id='center_column']/ul/li["+ (count+1) +"]//div[@class='left-block']//div[@class='content_price']/span[@class='price product-price']")).getText();
		}
		System.out.println(price[0]); */
	}
	
	
}
