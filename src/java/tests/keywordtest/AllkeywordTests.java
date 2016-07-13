package keywordtest;

import java.io.IOException;

import org.testng.annotations.Test;

import customexception.NoSuchKeywordException;
import drivers.StartWedDriver;
import excelhelpers.ExcelHelper;
import keyworddriven.KeywordDefinition;

public class AllkeywordTests extends StartWedDriver  {

	@Test
	public void loginTest() throws IOException, NoSuchKeywordException{
		KeywordDefinition.performactionbasedonKeyword(ExcelHelper.keywordTestcaseFilePath, ExcelHelper.loginTestSheetName);
	}
	
	@Test
	public void canGoToMensFormalShoePage() throws IOException, NoSuchKeywordException {
		KeywordDefinition.performactionbasedonKeyword(ExcelHelper.keywordTestcaseFilePath, ExcelHelper.canGoToMensFormalShoPpage);
	}
}
