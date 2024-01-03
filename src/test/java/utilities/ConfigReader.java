package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.checkerframework.common.reflection.qual.GetClass;

public class ConfigReader {

	private static Properties prop;
	private static String browserType;
	private final static String propertyFilePath = "config/Config.properties";

	/**
	 * This method is used to load the properties from config.properties file
	 * 
	 * @return it returns Properties prop object
	 */
	public static void init_prop() {

		try {
			InputStream fis;
			fis = ConfigReader.class.getClassLoader().getResourceAsStream(propertyFilePath);
			prop = new Properties();

			try {
				prop.load(fis);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Config.properties not found at" + propertyFilePath);
		}
	}

	public static void setbrowser(String browser) {
		browserType = browser;
	}

	public static String getBrowserType() {
		String browserType = prop.getProperty("browser");
		if (browserType != null)
			return browserType;
		else
			throw new RuntimeException("browser not specified in the Configuration.properties file.");
	}

	public static String getApplicationUrl() {
		String url = prop.getProperty("SFurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public static String getUsername() {
		String username = prop.getProperty("username");
		return username;

	}

	public static String getPassword() {

		String password = prop.getProperty("password");
		return password;
	}

	public static String getFilePath() {
		String filePath = prop.getProperty("filePath");
		return filePath;
	}
}