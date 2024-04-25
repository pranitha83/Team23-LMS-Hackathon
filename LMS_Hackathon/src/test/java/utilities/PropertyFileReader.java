package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

	private final static String propertyFilePath = "./src/test/resources/config.properties";
	
	
	static FileInputStream fis;
	static Properties prop;

	public static String getGlobalValue(String key) throws Throwable {
		try {
			prop = new Properties();
			fis = new FileInputStream(propertyFilePath);
			prop.load(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		return prop.getProperty(key);
	}
	
	public static String getexcelfilepath() {
		String excelfilelpath = prop.getProperty("excelfilepath");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
	}

public static  String getbrowser() {
	String browserName = prop.getProperty("browser");
	return browserName;
}

public static String getUrl() throws Throwable {
	String url = getGlobalValue("url");
	return url;
}
}