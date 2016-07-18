package helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.StartWedDriver;

public class GenericHelpers extends StartWedDriver {

	public static WebElement WaitForElementToBeClickable(int delay, By locator){
		WebDriverWait wait = new WebDriverWait(driver, delay);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebElement WaitForElementTobeVisible(int delay, By locator){
		return new WebDriverWait(driver, delay).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static Alert WaitForAlertToBePresent(int delay){
		WebDriverWait wait = new WebDriverWait(driver, delay);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void waitForFrameToBePresentAndSwitchTo(int delay, By locator){
		WebDriverWait wait = new WebDriverWait(driver, delay);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
}
