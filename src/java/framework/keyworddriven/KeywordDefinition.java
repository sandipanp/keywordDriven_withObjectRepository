package keyworddriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import customexception.NoSuchKeywordException;
import excelhelpers.ExcelFilePathSheetColHelper;
import functionalibrary.LoginLogout;
import functionalibrary.Navigation;
import helpers.ActionHelper;
import helpers.ButtonHelper;
import helpers.ComboboxHelper;
import helpers.LinkHelper;
import helpers.TextBoxHelper;
import helpers.VerificationHelper;

public class KeywordDefinition {

	private static FileInputStream fin;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	
	public static void performactionbasedonKeyword(String filePath,String sheetName) throws IOException, NoSuchKeywordException{
		try {
			fin = new FileInputStream(new File(filePath));
			workbook = new XSSFWorkbook(fin);
			sheet = workbook.getSheet(sheetName);
			for(int rowCount = 1; rowCount <= sheet.getLastRowNum(); rowCount++){
				row = sheet.getRow(rowCount);
				switch (row.getCell(ExcelFilePathSheetColHelper.actions).getStringCellValue()) {
				case "clickLink":
					LinkHelper.clickLinkByKeyword(row);
					break;
				case "enterText":
					TextBoxHelper.enterTextByKeyword(row);
					break;
				case "clickButton":
					ButtonHelper.clickButtonByKeyword(row);
					break;
				case "verifyExactText":
					VerificationHelper.verifyExactTextByKeyword(row);
					break;
				case "loginToSite":
					LoginLogout.LoginToSiteByKeyword();
					break;
				case "moveToElement":
					ActionHelper.moveToElementByKeyword(row);
					break;
				case "moveToElementAndClick":
					ActionHelper.moveToElementAndClickByKeyword(row);
					break;
				case "verifyTextContains":
					VerificationHelper.verifyTextContainsByKeyword(row);
					break;
				case "logoutFromSite":
					LoginLogout.logoutFromSite();
					break;
				case "moveToMensFormalShoePage":
					Navigation.moveToMensFormalShoePage();
					break;
				case "selectComboOption":
					ComboboxHelper.selectComboOptionByKeyword(row);
					break;
				case "verifyComboSelection":
					VerificationHelper.verifyComboSelectionByKeyword(row);
					break;
				case "verifyFormalShoeAddedToCart":
					VerificationHelper.verifyFormalShoeAddedToCartByKeyword(row);
					break;
				default:
					throw new NoSuchKeywordException("No keyword found : " + row.getCell(ExcelFilePathSheetColHelper.actions).getStringCellValue());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			fin.close();
			workbook = null;
			row = null;
			fin = null;
		}
	}
}
