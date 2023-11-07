package stepDefinitions;

import org.openqa.selenium.WebDriver;

import DriverFactory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PatientObject;

import utilities.loggerLoad;

public class PatientObjectSD {


	PatientObject patient = new PatientObject();
	@Given("patient is on patient Personal Information page")
	public void patient_is_on_patient_personal_information_page() {
	    
	}


	@When("Patient enters the First Name in {string}")
	public void patient_enters_the_first_name_in(String First_Name) {
		patient.enterFirstName(First_Name);
	}
	@And("Patient enters the Last Name in {string}")
	public void patient_enters_the_last_name_in(String Last_Name) {
		patient.enterLastName(Last_Name);
	}
	@Then("after filling the form with manadatory fileds and saving,the First Name status should be {string}")
	public void after_filling_the_form_with_manadatory_fileds_and_saving_the_first_name_status_should_be(
			String status) {
		patient.Name_Status(status);

	}

	
}
