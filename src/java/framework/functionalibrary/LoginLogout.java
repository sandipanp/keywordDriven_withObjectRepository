package functionalibrary;

import drivers.StartWedDriver;
import helpers.ButtonHelper;
import helpers.LinkHelper;
import helpers.TextBoxHelper;

public class LoginLogout extends StartWedDriver {

	public static void loginToSite(String username, String password){
		
		LinkHelper.clickLink(objectRepo.getLocator("leathershop.homepage.signinlink"));
		TextBoxHelper.enterText(objectRepo.getLocator("leathershop.signinpage.username"), username);
		TextBoxHelper.enterText(objectRepo.getLocator("leathershop.signinpage.password"), password);
		ButtonHelper.clickButton(objectRepo.getLocator("leathershop.signinpage.signinbutton"));
	}
	
	public static void logoutFromSite(){
		LinkHelper.clickLink(objectRepo.getLocator("leathershop.anypage.signout"));
	}

	public static void LoginToSiteByKeyword() {
		loginToSite(configProp.getUsername(), configProp.getPassword());
	}
}
