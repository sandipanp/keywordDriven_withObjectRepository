package helpers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import drivers.StartWedDriver;
import excelhelpers.ExcelHelper;

public class ActionHelper extends StartWedDriver {

	public static void moveToElement(By locator) {
		Actions act = new Actions(driver);
		WebElement element = GenericHelpers.WaitForElementTobeVisible(30, locator);
		act.moveToElement(element)
			.build()
			.perform();
	}
	
	public static void moveToElementAndClick(By locator) {
		Actions act = new Actions(driver);
		WebElement element = GenericHelpers.WaitForElementToBeClickable(30, locator);
		act.moveToElement(element)
			.click()
			.build()
			.perform();
	}

	public static void moveToElementByKeyword(XSSFRow row) {
		moveToElement(objectRepo.getLocator(row.getCell(ExcelHelper.locatorKey).getStringCellValue()));
	}

	public static void moveToElementAndClickByKeyword(XSSFRow row) {
		moveToElementAndClick(objectRepo.getLocator(row.getCell(ExcelHelper.locatorKey).getStringCellValue()));
		
	}
}
