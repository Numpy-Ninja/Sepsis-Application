package applicationHooks;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import DriverFactory.BaseClass;

import utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;


public class AppHooks  {
	private static WebDriver driver;
	private static BaseClass driverfactory;

	@BeforeAll
	public static void before() throws Throwable {
		// Get browser Type from config file
		
		ConfigReader.init_prop();	
		String browser = ConfigReader.getBrowserType();
		System.out.println(ConfigReader.getBrowserType());

		// Initialize driver from driver factory
		driverfactory = new BaseClass();
		driver = BaseClass.init_driver(browser);
		
	}
	@AfterStep
	public void afterstep(Scenario scenario) {
		if (scenario.isFailed()) {
			
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My screenshot");
			Allure.addAttachment("Myscreenshot",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

		}
	}

    
	@AfterAll
	public static void after() {
	
		driverfactory.closeallDriver();

	}
}
	

