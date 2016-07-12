package excelhelpers;

public class ExcelHelper {

	//Excel column helper
	public static int locatorKey =  2;
	public static int actions = 3;
	public static int testData = 4;
	
	// keyword excel sheet location and sheet name
	public static String keywordTestcaseFilePath = ExcelHelper.class.getClassLoader().getResource("keywordtestcases/TestCases.xlsx").getPath();
	public static String loginTestSheetName = "leathershoplogin";
}
