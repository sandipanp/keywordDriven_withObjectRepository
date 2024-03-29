package drivers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperty {

	protected InputStream inputStream;
	protected Properties prop;
	
	public ReadConfigProperty() throws IOException{
		inputStream = ReadConfigProperty.class.getClassLoader().getResourceAsStream("resources/config.properties");
		prop = new Properties();
		prop.load(inputStream);
		inputStream.close();
	}
	
	public String getUsername(){
		return prop.getProperty("username");
	}
	
	public String getPassword(){
		return prop.getProperty("password");
	}
	
	public String getBrowserType(){
		return prop.getProperty("browser");
	}
	
	public String getURl(){
		return prop.getProperty("url");
	}
	
	public int getPageLoadWaitTime(){
		return Integer.parseInt(prop.getProperty("PageLoadWaitTime"));
	}
	
	public int getImplisitWaitTime(){
		return Integer.parseInt(prop.getProperty("ElementWaitTime"));
	}
	
	/*
	public String getMasterTestDataFile(){
		return prop.getProperty("mastertestdatafile");
	}
	
	public String getTestDataSheetName(){
		return prop.getProperty("testdatasheet");
	}*/
}
