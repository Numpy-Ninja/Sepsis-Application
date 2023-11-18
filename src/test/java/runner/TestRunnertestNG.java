package runner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty","html:target/cucumber.html" ,"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
publish=true,
monochrome = false, // console output
	
features = { "src/test/resources/features" }, // location of feature files
//tags=" @NewPatientInformation",// tags from feature file,
glue = { "stepDefinitions","applicationHooks" }// location of step definition files

) 

public class TestRunnertestNG extends AbstractTestNGCucumberTests {
@DataProvider(parallel = false)
public Object[][] scenarios() {		
return super.scenarios();
}

}



















