package stepDefinitions;

import org.openqa.selenium.WebDriver;

import DriverFactory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ExistingMorbidities;

import utilities.configReader;


public class commonSD {


	ExistingMorbidities patientEM = new ExistingMorbidities();
	String username = configReader.getUsername();
	String password = configReader.getPassword();

	@Given("The patient is on Signin page of salesforce application")
	public void the_patient_is_on_signin_page_of_salesforce_application() {
	
		patientEM.SalesForcelogin_page();
	}

	@When("The patient enter valid {string} and {string}")
	public void the_patient_enter_valid_and(String userName, String passWord) {
		patientEM.Login(username,password);
	    
	}

	@And("The user click on login button")
	public void the_user_click_on_login_button() {
		patientEM.login_button();
	   
	}

	@Then("The user redirected to SalesForceHomepage")
	public void the_user_redirected_to_sales_force_homepage() throws InterruptedException {
		Thread.sleep(3000);
		patientEM.waffle_click();
		patientEM.sepsisApp_click();
		patientEM.patientObject_select();
		patientEM.selectNew();
		//patient.next_btn();
	    
	}

}
