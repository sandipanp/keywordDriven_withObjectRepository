package helpers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;

import drivers.StartWedDriver;
import excelhelpers.ExcelHelper;

public class LinkHelper extends StartWedDriver {

	public static void clickLink(By locator){
		GenericHelpers.WaitForElementToBeClickable(30, locator).click();
	}

	public static void clickLinkByKeyword(XSSFRow row) {
		String locatorKey = row.getCell(ExcelHelper.locatorKey).getStringCellValue();
		clickLink(objectRepo.getLocator(locatorKey));
	}
}
