package helpers;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.testng.Assert;

import drivers.StartWedDriver;
import excelhelpers.ExcelHelper;

public class VerificationHelper extends StartWedDriver {

	public static void verifyExactText(String expectedText, By locator){
		String actualText = GenericHelpers.WaitForElementTobeVisible(30, locator).getText();
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText), "Actula text is not equal to expected text");
	}

	public static void verifyExactTextByKeyword(XSSFRow row) {
		String locatorKey = row.getCell(ExcelHelper.locatorKey).getStringCellValue();
		verifyExactText(row.getCell(ExcelHelper.verificationText).getStringCellValue(), objectRepo.getLocator(locatorKey));
		
	}
	
	public static void verifyTextContains(By locator, String expectedTextContains) {
		String actualText = GenericHelpers.WaitForElementTobeVisible(30, locator).getText();
		Assert.assertTrue(actualText.contains(expectedTextContains), "Actual text does not contains expected text");
	}

	public static void verifyTextContainsByKeyword(XSSFRow row) {
		verifyTextContains(objectRepo.getLocator(row.getCell(ExcelHelper.locatorKey).getStringCellValue()), row.getCell(ExcelHelper.verificationText).getStringCellValue());
	}
	
	public static void verifyExactText(String actualText, String expectedText){
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText), "Actula text is not equal to expected text");
	}
	
	public static void verifyComboSelection(By locator, String expectedText){
		String selectedText = ComboboxHelper.getSelectedText(locator);
		Assert.assertTrue(selectedText.equals(expectedText), "Combo Selection failed");
	}

	public static void verifyComboSelectionByKeyword(XSSFRow row) {
		verifyComboSelection(objectRepo.getLocator(row.getCell(ExcelHelper.locatorKey).getStringCellValue()), row.getCell(ExcelHelper.verificationText).getStringCellValue());
		
	}
}
