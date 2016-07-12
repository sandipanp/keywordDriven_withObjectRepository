package helpers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;

import drivers.StartWedDriver;
import excelhelpers.ExcelHelper;

public class TextBoxHelper extends StartWedDriver {

	public static void enterText(By locator, String textToBeSend){
		GenericHelpers.WaitForElementToBeClickable(30, locator).sendKeys(textToBeSend);
	}

	public static void enterTextByKeyword(XSSFRow row) {
		String locatorKey = row.getCell(ExcelHelper.locatorKey).getStringCellValue();
		enterText(objectRepo.getLocator(locatorKey), row.getCell(ExcelHelper.testData).getStringCellValue());
	}
}
