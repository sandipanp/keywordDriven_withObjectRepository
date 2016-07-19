package helpers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import drivers.StartWedDriver;
import excelhelpers.ExcelFilePathSheetColHelper;
import logger.SELENIUMLogger;

public class ComboboxHelper extends StartWedDriver {

	public static void selectComboOption(By locator, String visibleText) {
		SELENIUMLogger.Log("selectComboOption  enter");
		Select sel = new Select(driver.findElement(locator));
		sel.selectByVisibleText(visibleText);
		SELENIUMLogger.Log("selectComboOption  exit");
	}
	
	public static String getSelectedText(By locator){
		SELENIUMLogger.Log("getSelectedText  enter");
		Select sel = new Select(driver.findElement(locator));
		String selectedOption = sel.getFirstSelectedOption().getText();
		SELENIUMLogger.Log("getSelectedText  returning");
		return selectedOption;
	}

	public static void selectComboOptionByKeyword(XSSFRow row) {
		SELENIUMLogger.Log("selectComboOptionByKeyword  enter");
		selectComboOption(objectRepo.getLocator(row.getCell(ExcelFilePathSheetColHelper.locatorKey).getStringCellValue()), row.getCell(ExcelFilePathSheetColHelper.testData).getStringCellValue());
		SELENIUMLogger.Log("selectComboOptionByKeyword  exit");
	}
}
