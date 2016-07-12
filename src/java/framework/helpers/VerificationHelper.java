package helpers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.testng.Assert;

import drivers.StartWedDriver;
import excelhelpers.ExcelHelper;

public class VerificationHelper extends StartWedDriver {

	public static void verifyText(String expectedText, By locator){
		String actualText = GenericHelpers.WaitForElementTobeVisible(30, locator).getText();
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText), "Login Failure");
	}

	public static void verifyTextByKeyword(XSSFRow row) {
		String locatorKey = row.getCell(ExcelHelper.locatorKey).getStringCellValue();
		verifyText(row.getCell(ExcelHelper.testData).getStringCellValue(), objectRepo.getLocator(locatorKey));
		
	}
}
