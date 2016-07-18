package keywordtest;

import java.io.IOException;

import org.testng.annotations.Test;

import customexception.NoSuchKeywordException;
import drivers.StartWedDriver;
import excelhelpers.ExcelFilePathSheetColHelper;
import keyworddriven.KeywordDefinition;

public class AllkeywordTests extends StartWedDriver  {

	@Test(enabled=true)
	public void loginTest() throws IOException, NoSuchKeywordException{
		KeywordDefinition.performactionbasedonKeyword(ExcelFilePathSheetColHelper.keywordTestcaseFilePath, ExcelFilePathSheetColHelper.loginTestSheetName);
	}
	
	@Test(enabled=true)
	public void canGoToMensFormalShoePageTest() throws IOException, NoSuchKeywordException {
		KeywordDefinition.performactionbasedonKeyword(ExcelFilePathSheetColHelper.keywordTestcaseFilePath, ExcelFilePathSheetColHelper.canGoToMensFormalShoPpage);
	}
	
	@Test(enabled=true)
	public void formalShoePageSortingTest() throws IOException, NoSuchKeywordException{
		KeywordDefinition.performactionbasedonKeyword(ExcelFilePathSheetColHelper.keywordTestcaseFilePath, ExcelFilePathSheetColHelper.formalShoepageSorting);
	}
}
