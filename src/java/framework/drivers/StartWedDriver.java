package drivers;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import excelhelpers.ExcelFilePathSheetColHelper;
import logger.SELENIUMLogger;


public class StartWedDriver extends ExcelFilePathSheetColHelper{

	public static WebDriver driver;
	public static ReadConfigProperty configProp;
	public static ReadObjectRepository objectRepo;
	
	@BeforeMethod
	public void SetUp(){
		try {
			objectRepo = new ReadObjectRepository();
			configProp = new ReadConfigProperty();
			SELENIUMLogger.Configure();
			switch (configProp.getBrowserType()) {
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver",StartWedDriver.class.getClassLoader().getResource("resources/chromedriver.exe").getPath());
				driver = new ChromeDriver();
			case "ie":
				System.setProperty("webdriver.ie.driver",StartWedDriver.class.getClassLoader().getResource("resources/IEDriverServer.exe").getPath());
				driver = new InternetExplorerDriver();
			default:
				System.out.println("No such browser found");
				break;
			}
			driver.manage().timeouts().pageLoadTimeout(configProp.getPageLoadWaitTime(), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(configProp.getImplisitWaitTime(), TimeUnit.SECONDS);
			driver.get(configProp.getURl());
			
			
		} catch (IOException e) {
			SELENIUMLogger.Log("StartWedDriver : Failed");
		}
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.close();
		driver.quit();
		if(driver != null)
			driver = null;
	}
	
	@DataProvider
	  public Object[][] dataProvider(Method method) throws IOException
	  {
		//configProp = new ReadConfigProperty();
		DataDrivenHelper ddh = new DataDrivenHelper(ExcelFilePathSheetColHelper.testDataFilePath);
			
		Object[][] testData= ddh.getTestCaseDataSets(ExcelFilePathSheetColHelper.testDataSheet, method.getName());
		
		return testData;
			
	  }
}
