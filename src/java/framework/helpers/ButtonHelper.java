package helpers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;

import drivers.StartWedDriver;
import excelhelpers.ExcelFilePathSheetColHelper;

public class ButtonHelper extends StartWedDriver {

	public static void clickButton(By locator){
		GenericHelpers.WaitForElementToBeClickable(30, locator).click();
	}

	public static void clickButtonByKeyword(XSSFRow row) {
		String locatorKey = row.getCell(ExcelFilePathSheetColHelper.locatorKey).getStringCellValue();
		clickButton(objectRepo.getLocator(locatorKey));
		
	}
}
