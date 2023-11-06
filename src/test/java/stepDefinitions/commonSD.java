package stepDefinitions;

import org.openqa.selenium.WebDriver;

import DriverFactory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PatientObject;


public class commonSD {

	public WebDriver driver=BaseClass.getdriver();
	PatientObject patient = new PatientObject(driver);

	@Given("The patient is on Signin page of salesforce application")
	public void the_patient_is_on_signin_page_of_salesforce_application() {
	
		patient.SalesForcelogin_page();
	}

	@When("The patient enter valid {string} and {string}")
	public void the_patient_enter_valid_and(String username, String password) {
		patient.Login();
	    
	}

	@And("The user click on login button")
	public void the_user_click_on_login_button() {
		patient.login_button();
	   
	}

	@Then("The user redirected to SalesForceHomepage")
	public void the_user_redirected_to_sales_force_homepage() {
		patient.waffle_click();
		patient.sepsisApp_click();
		patient.patientObject_select();
		patient.selectNew();
		patient.next_btn();
	    
	}

}
