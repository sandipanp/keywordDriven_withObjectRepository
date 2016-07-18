package helpers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import drivers.StartWedDriver;

public class WindowsHelper extends StartWedDriver {
	
	public static void switchToWindow(int index){
		List<String> wins = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wins.get(index));
	}
	
	public static void switchToFrame(By locator){
		GenericHelpers.waitForFrameToBePresentAndSwitchTo(30, locator);
	}
	
	public static void navigateBack(){
		driver.navigate().back();
	}

	public static void navigateForward(){
		driver.navigate().forward();
	}
	
	public static void navivateToURL(String url){
		driver.navigate().to(url);
	}
	
	public static void refreshPage(){
		driver.navigate().refresh();
	}
}
