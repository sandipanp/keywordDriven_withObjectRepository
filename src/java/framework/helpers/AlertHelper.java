package helpers;

import org.openqa.selenium.Alert;

import drivers.StartWedDriver;

public class AlertHelper extends StartWedDriver {

	public static void acceptAlertMessage(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
	}
	
	public static void dismissAlert(){
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		driver.switchTo().defaultContent();
	}
	
	public static void sendTextAndAccept(String text){
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
		driver.switchTo().defaultContent();
	}
	
	public static String getAlertMessage(){
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
}
