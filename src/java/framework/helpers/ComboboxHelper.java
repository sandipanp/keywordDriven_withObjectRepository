package helpers;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;


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
		} catch(UnexpectedTagNameException e) {
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
	
	public static List<WebElement> getOptions(By locator){
		Select dropdown = new Select(driver.findElement(locator));
		return dropdown.getOptions();
	}
	
	public static List<String> getOptionsText(By locator){
		Select dropdown = new Select(driver.findElement(locator));
		List<WebElement> options = new ArrayList<WebElement>();
		options = dropdown.getOptions();
		List<String> optionTexts = new ArrayList<String>();
		for(WebElement ele : options)
			optionTexts.add(ele.getText());
		return optionTexts;
	}
	
	public static void deselectAllOptions(By locator){
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.deselectAll();
	}
	
	public static void deselectOptionByIndex(By locator, int index){
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.deselectByIndex(index);
	}
	
	public static void deselectOptionsByValue(By locator, String value){
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.deselectByValue(value);
	}
}
