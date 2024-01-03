package runner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import applicationHooks.AppHooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber/report.html", "json:target/cucumber/report.json",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, publish = true, monochrome = false, // console
		features = { "src/test/resources/features/" }, // location of feature files
		glue = { "stepDefinitions", "applicationHooks" }// location of step definition files

)

public class TestRunnertestNG extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@Parameters({ "browserName" })
	@BeforeTest
	public static void setUpScenario(String browser) {
		try {
			AppHooks.initSetup(browser);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
