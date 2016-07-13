package keywordtest;

import java.io.IOException;

import org.testng.annotations.Test;

import customexception.NoSuchKeywordException;
import drivers.StartWedDriver;
import excelhelpers.ExcelHelper;
import keyworddriven.KeywordDefinition;

public class AllkeywordTests extends StartWedDriver  {

	@Test(enabled=true)
	public void loginTest() throws IOException, NoSuchKeywordException{
		KeywordDefinition.performactionbasedonKeyword(ExcelHelper.keywordTestcaseFilePath, ExcelHelper.loginTestSheetName);
	}
	
	@Test(enabled=true)
	public void canGoToMensFormalShoePageTest() throws IOException, NoSuchKeywordException {
		KeywordDefinition.performactionbasedonKeyword(ExcelHelper.keywordTestcaseFilePath, ExcelHelper.canGoToMensFormalShoPpage);
	}
	
	@Test(enabled=true)
	public void formalShoePageSortingTest() throws IOException, NoSuchKeywordException{
		KeywordDefinition.performactionbasedonKeyword(ExcelHelper.keywordTestcaseFilePath, ExcelHelper.formalShoepageSorting);
	}
}
