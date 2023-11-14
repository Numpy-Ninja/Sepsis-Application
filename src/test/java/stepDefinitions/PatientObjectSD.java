package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass; 
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PatientObject;
import utilities.ConfigReader;
import utilities.loggerLoad;

public class PatientObjectSD {

	private static Logger logger = LogManager.getLogger(PatientObjectSD.class);

	PatientObject patient = new PatientObject();
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getPassword();

	
	@Given("Patient is on New patient form")
	public void patient_is_on_new_patient_form() {
		//patient.SalesForcelogin_page();
		//patient.Login(ConfigReader.getUsername(),ConfigReader.getPassword());
		logger.info("Patient is on new patient form");

	}
	@When("Patient enters {string} and {string}")
	public void patient_enters (String fullname, String contactnumber) {
		patient.emergencyInfo(fullname, contactnumber);
		patient.relationshipDropDown();

	}
	@Then("Patient can see the {string} and {string}entered on emergency contact info")
	public void patient_can_see_the_and_entered_on_emergency_contact_info(String fullname, String contactnumber) {
		String fullName = patient.checkFullNameEntered();
		String contactNumber = patient.checkContactNumberEntered();
		assertEquals(fullName, fullname);
		assertEquals(contactNumber, contactnumber);

	}
	
	@Given("Patient is on same patient form")
	public void patient_is_on_same_patient_form() {
		logger.info("Patient is on same patient form");	
	}
	
	@When("Patient enters {string} and {string} and {string} and {string}")
	public void patient_enters_and_and_and(String doctorName, String doctorContactNumber, String clinicName, String doctorEmail) {
		patient.providerInformation(doctorName, doctorContactNumber, clinicName, doctorEmail);
	
	}

	@Then("Patient can see the {string} and {string} and {string} and {string} entered on provider information")
	public void patient_can_see_the_and_and_and_entered_on_provider_information(String doctorName, String doctorContactNumber, String clinicName, String doctorEmail) {
		String docName = patient.checkDoctorNameEntered();
		String docContactNumber = patient.checkDoctorContactNumberEntered();
		String clinicname = patient.checkClinicNameEntered();
		String docEmail = patient.checkDoctorEmailEntered();
		assertEquals(docName, doctorName);
		assertEquals(docContactNumber, doctorContactNumber);
		assertEquals(clinicname, clinicName);
		assertEquals(docEmail, doctorEmail);
	}
	
	@When("Patient enters {string} and {string} on medical history")
	public void patient_enters_and_on_medical_history(String heightInCm, String weightInKg) {
	    patient.medicalHistory(heightInCm, weightInKg);
	}
	
	@Then("Patient can see the {string} and {string} entered on medical history")
	public void patient_can_see_the_and_entered_on_medical_history(String heightInCm, String weightInKg) {
		String height = patient.checkHeightEntered();
		String weight = patient.checkWeightEntered();
		assertEquals(height, heightInCm);
		assertEquals(weight, weightInKg);
	}
	
	@When("Patient enters {string} and {string} Gender and DOB on personal information")
	public void patient_enters_and_on_personal_information(String firstName, String lastName) {
		patient.personalInfo(firstName, lastName);

	}

	@Then("Patient can see the {string} and {string} and other details entered on personal information")
	public void patient_can_see_the_and_and_other_details_entered_on_personal_information(String firstName, String lastName) {
		String firtname = patient.checkFirstNameEntered();
		String lastname = patient.checkLastNameEntered();
		assertEquals(firtname, firstName);
		assertEquals(lastname, lastName);
		assertEquals(patient.checkDOBSelected(), "11/1/2023");
	}
}
