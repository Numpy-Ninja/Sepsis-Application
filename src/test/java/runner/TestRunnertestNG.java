package runner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( // reporting purpose

publish=true,
monochrome = false, // console output
	
features = { "src/test/resources/features" }, // location of feature files
tags=" ",// tags from feature file,
glue = { "stepDefinitions","Hooks" }// location of step definition files

) 

public class TestRunnertestNG extends AbstractTestNGCucumberTests {
@DataProvider(parallel = false)
public Object[][] scenarios() {		
return super.scenarios();
}

}



















