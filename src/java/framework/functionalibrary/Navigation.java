package functionalibrary;

import drivers.StartWedDriver;
import helpers.ActionHelper;

public class Navigation extends StartWedDriver {

	public static void moveToMensFormalShoePage() {
		// Move on Menu Option :  Men
		ActionHelper.moveToElement(objectRepo.getLocator("leathershop.menu.men"));
						
		// Move to sub menu Click on SubMenu Option : Formal
		ActionHelper.moveToElementAndClick(objectRepo.getLocator("leathershop.men.submenu.formal"));
		
		
	}
}
