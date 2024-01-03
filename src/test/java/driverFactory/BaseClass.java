package driverFactory;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static WebDriver init_driver(String browser) {
String browserType = System.getProperty("browserProperty");
		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");


			driver = new ChromeDriver(option);

		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.out.println(new File(".").getPath());
			System.setProperty("webdriver.gecko.driver", "Drivers/firefoxdriver/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver", "Drivers/Edgedriver/msedgedriver");
			// edgeOptions.addArguments("--headless");
			driver = new EdgeDriver(edgeOptions);
		} else {
			throw new RuntimeException("BrowserType Not Supported");

		}

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		return driver;

	}

	public static WebDriver getdriver() {
		return driver;

	}
	
	public void closeallDriver() {
		driver.close();
	}

}
