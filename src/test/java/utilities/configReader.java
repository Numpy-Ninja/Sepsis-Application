package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class configReader {

	public static Properties prop;

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	public static Properties init_prop() {

	
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			 prop = new Properties();
			prop.load(fis);
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
	public static String getBrowserType() {
		String browser = prop.getProperty("browser");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("browser not specified in the Configuration.properties file.");
	}
	public static String getApplicationUrl() {
		String SFurl = prop.getProperty("url");
		if (SFurl != null)
			return SFurl;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
public static String getUsername()
{
	String username=prop.getProperty("username");
	return username;
	
}
public static String getPassword()
{

	String password=prop.getProperty("password");
	return password;
}
}