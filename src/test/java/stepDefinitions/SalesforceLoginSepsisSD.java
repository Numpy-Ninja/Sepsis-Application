package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import driverFactory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SalesforceLoginSepsis;
import utilities.ConfigReader;

public class SalesforceLoginSepsisSD {

	SalesforceLoginSepsis loginPatient = new SalesforceLoginSepsis();
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getPassword();

	@Given("The patient is on Signin page of salesforce application")
	public void the_patient_is_on_signin_page_of_salesforce_application() {

		loginPatient.SalesForcelogin_page();
	}

	@When("The patient enter valid {string} and {string}")
	public void the_patient_enter_valid_and(String userName, String passWord) {
		loginPatient.Login(username, password);

	}

	@And("The user click on login button")
	public void the_user_click_on_login_button() throws InterruptedException {
		loginPatient.login_button();
		
		loginPatient.waffle_click();
		loginPatient.sepsisApp_click();
	
		
	}

	@Then("The user redirected to SalesForceHomepage")
	public void the_user_redirected_to_sales_force_homepage() {

		loginPatient.patientObject_select();
		

	}

}
