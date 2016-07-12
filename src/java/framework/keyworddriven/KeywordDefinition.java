package keyworddriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import customexception.NoSuchKeywordException;
import excelhelpers.ExcelHelper;
import helpers.ButtonHelper;
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
				switch (row.getCell(ExcelHelper.actions).getStringCellValue()) {
				case "clickLink":
					LinkHelper.clickLinkByKeyword(row);
					break;
				case "enterText":
					TextBoxHelper.enterTextByKeyword(row);
					break;
				case "clickButton":
					ButtonHelper.clickButtonByKeyword(row);
					break;
				case "verifyText":
					VerificationHelper.verifyTextByKeyword(row);
					break;
				default:
					throw new NoSuchKeywordException("No keyword found : " + row.getCell(ExcelHelper.actions).getStringCellValue());
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
