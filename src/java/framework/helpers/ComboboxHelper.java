package helpers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import drivers.StartWedDriver;
import excelhelpers.ExcelFilePathSheetColHelper;
import logger.SELENIUMLogger;

public class ComboboxHelper extends StartWedDriver {

	public static void selectComboOption(By locator, String visibleText) {
		try{
		SELENIUMLogger.Log("ComboboxHelper : selectComboOption  enter");
		Select sel = new Select(driver.findElement(locator));
		sel.selectByVisibleText(visibleText);
		SELENIUMLogger.Log("ComboboxHelper : selectComboOption  exit");
		} catch(Exception e) {
			SELENIUMLogger.Log("ComboboxHelper : selectComboOption => FAILED");
		}
	}
	
	public static String getSelectedText(By locator){
		SELENIUMLogger.Log("ComboboxHelper : getSelectedText  enter");
		Select sel = new Select(driver.findElement(locator));
		String selectedOption = sel.getFirstSelectedOption().getText();
		SELENIUMLogger.Log("ComboboxHelper : getSelectedText  returning");
		return selectedOption;
	}

	public static void selectComboOptionByKeyword(XSSFRow row) {
		SELENIUMLogger.Log("ComboboxHelper : selectComboOptionByKeyword  enter");
		selectComboOption(objectRepo.getLocator(row.getCell(ExcelFilePathSheetColHelper.locatorKey).getStringCellValue()), row.getCell(ExcelFilePathSheetColHelper.testData).getStringCellValue());
		SELENIUMLogger.Log("ComboboxHelper : selectComboOptionByKeyword  exit");
	}
}
