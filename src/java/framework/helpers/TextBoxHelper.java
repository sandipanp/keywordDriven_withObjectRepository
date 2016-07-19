package helpers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;

import drivers.StartWedDriver;
import excelhelpers.ExcelFilePathSheetColHelper;
import logger.SELENIUMLogger;

public class TextBoxHelper extends StartWedDriver {

	public static void enterText(By locator, String textToBeSend){
		SELENIUMLogger.Log("enterText  enter");
		GenericHelpers.WaitForElementToBeClickable(30, locator).sendKeys(textToBeSend);
		SELENIUMLogger.Log("enterText  exit");
	}

	public static void enterTextByKeyword(XSSFRow row) {
		SELENIUMLogger.Log("enterTextByKeyword  enter");
		String locatorKey = row.getCell(ExcelFilePathSheetColHelper.locatorKey).getStringCellValue();
		enterText(objectRepo.getLocator(locatorKey), row.getCell(ExcelFilePathSheetColHelper.testData).getStringCellValue());
		SELENIUMLogger.Log("enterTextByKeyword  exit");
	}
}
