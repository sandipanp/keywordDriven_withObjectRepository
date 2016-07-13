package helpers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import drivers.StartWedDriver;
import excelhelpers.ExcelHelper;

public class ComboboxHelper extends StartWedDriver {

	public static void selectComboOption(By locator, String visibleText) {
		Select sel = new Select(driver.findElement(locator));
		sel.selectByVisibleText(visibleText);
	}
	
	public static String getSelectedText(By locator){
		Select sel = new Select(driver.findElement(locator));
		String selectedOption = sel.getFirstSelectedOption().getText();
		return selectedOption;
	}

	public static void selectComboOptionByKeyword(XSSFRow row) {
		selectComboOption(objectRepo.getLocator(row.getCell(ExcelHelper.locatorKey).getStringCellValue()), row.getCell(ExcelHelper.testData).getStringCellValue());
		
	}
}
