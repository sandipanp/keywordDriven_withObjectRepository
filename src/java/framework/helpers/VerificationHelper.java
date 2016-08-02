package helpers;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.testng.Assert;

import drivers.StartWedDriver;
import excelhelpers.ExcelFilePathSheetColHelper;
import logger.SELENIUMLogger;

public class VerificationHelper extends StartWedDriver {

	public static void verifyExactText(String expectedText, By locator){
		String actualText = GenericHelpers.WaitForElementTobeVisible(30, locator).getText();
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText), "Actula text is not equal to expected text");
	}

	public static void verifyExactTextByKeyword(XSSFRow row) {
		String locatorKey = row.getCell(ExcelFilePathSheetColHelper.locatorKey).getStringCellValue();
		verifyExactText(row.getCell(ExcelFilePathSheetColHelper.verificationText).getStringCellValue(), objectRepo.getLocator(locatorKey));
		
	}
	
	public static void verifyTextContains(By locator, String expectedTextContains) {
		String actualText = GenericHelpers.WaitForElementTobeVisible(30, locator).getText();
		Assert.assertTrue(actualText.contains(expectedTextContains), "Actual text does not contains expected text");
	}

	public static void verifyTextContainsByKeyword(XSSFRow row) {
		verifyTextContains(objectRepo.getLocator(row.getCell(ExcelFilePathSheetColHelper.locatorKey).getStringCellValue()), row.getCell(ExcelFilePathSheetColHelper.verificationText).getStringCellValue());
	}
	
	public static void verifyExactText(String actualText, String expectedText){
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText), "Actula text is not equal to expected text");
	}
	
	public static void verifyComboSelection(By locator, String expectedText){
		String selectedText = ComboboxHelper.getSelectedText(locator);
		Assert.assertTrue(selectedText.equals(expectedText), "Combo Selection failed");
	}

	public static void verifyComboSelectionByKeyword(XSSFRow row) {
		verifyComboSelection(objectRepo.getLocator(row.getCell(ExcelFilePathSheetColHelper.locatorKey).getStringCellValue()), row.getCell(ExcelFilePathSheetColHelper.verificationText).getStringCellValue());
		
	}
	
	public static void verifyFormalShoeAddedToCart(String expectedText, By locator){
		/*try {
			WebTable table = new WebTable(driver.findElement(locator));
			String actualText = table.getCellText(1, 2);
			Assert.assertTrue(actualText.equalsIgnoreCase(expectedText), "Wrong show added to cart");
		} catch (AssertionError e) {
			SELENIUMLogger.Log("VERIFICATION FAILED : verifyFormalShoeAddedToCart ");
		}*/
		WebTable table = new WebTable(driver.findElement(locator));
		String actualText = table.getCellText(1, 2);
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText), "Wrong shoe added to cart");
	}

	public static void verifyFormalShoeAddedToCartByKeyword(XSSFRow row) {
		verifyFormalShoeAddedToCart(row.getCell(ExcelFilePathSheetColHelper.verificationText).getStringCellValue(), objectRepo.getLocator(row.getCell(ExcelFilePathSheetColHelper.locatorKey).getStringCellValue()));
		
	}
}
