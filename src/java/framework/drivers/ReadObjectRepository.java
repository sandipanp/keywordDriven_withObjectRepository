package drivers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ReadObjectRepository {

	private InputStream inputStraem;
	private Properties prop;
	
	public ReadObjectRepository() throws IOException{
		
		try {
			inputStraem =ReadObjectRepository.class.getClassLoader().getResourceAsStream("objectRepository/page.properties"); 
			prop = new Properties();
			prop.load(inputStraem);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			inputStraem.close();
		}
	}
	
	public By getLocator(String strElementasKey){
		String locator = prop.getProperty(strElementasKey);
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		
		if(locatorType.equalsIgnoreCase("id"))
			return By.id(locatorValue);
		else if(locatorType.equalsIgnoreCase("name"))
			return By.name(locatorValue);
		else if(locatorType.equalsIgnoreCase("classname"))
			return By.className(locatorValue);
		else if(locatorType.equalsIgnoreCase("tagname"))
			return By.tagName(locatorValue);
		else if(locatorType.equalsIgnoreCase("linktext"))
			return By.linkText(locatorValue);
		else if(locatorType.equalsIgnoreCase("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if(locatorType.equalsIgnoreCase("cssselector"))
			return By.cssSelector(locatorValue);
		else if(locatorType.equalsIgnoreCase("xpath"))
			return By.xpath(locatorValue);
		else
			throw new NoSuchElementException("Element is not found : " + locatorType + "=>" + locatorValue);
	}
}
