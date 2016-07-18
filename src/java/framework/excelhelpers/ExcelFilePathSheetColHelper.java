package excelhelpers;

public class ExcelFilePathSheetColHelper {

	//Excel column helper
	public static int locatorKey =  2;
	public static int actions = 3;
	public static int testData = 4;
	public static int verificationText = 5;
	
	// keyword excel sheet location and sheet name
	public static String keywordTestcaseFilePath = ExcelFilePathSheetColHelper.class.getClassLoader().getResource("keywordtestcases/TestCases.xlsx").getPath();
	public static String loginTestSheetName = "leathershoplogin";
	
	public static String canGoToMensFormalShoPpage = "cangotomensformalshoepage";
	public static String formalShoepageSorting = "formalShoepageSorting";
	
	public static String testDataFilePath = ExcelFilePathSheetColHelper.class.getClassLoader().getResource("datafiles/MasterTestDataFile.xlsx").getPath();
	public static String testDataSheet = "TestCaseDataSets";
}
