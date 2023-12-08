package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import driverFactory.AbstractComponents;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PatientObjectMandatory;
import pageObjects.data.PatientData;
import utilities.ConfigReader;
import utilities.PatientDataReader;

public class PatientObjectMandatorySD {

	private static Logger logger = LogManager.getLogger(PatientObjectMandatorySD.class);

	PatientObjectMandatory patient = PatientObjectMandatory.getInstance();
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getPassword();
	PatientDataReader dataReader = new PatientDataReader();

	@Given("Patient is on New patient form for entering patient details")
	public void patient_is_on_new_patient_form_for_entering_patient_details() {
		patient.patientObject_select();
		patient.newPatientform();
		logger.info("Patient is on new patient form");
	}

	@When("Patient submits new patient form with missing data from {string} and {int}")
	public void patient_submits_new_patient_form_with_missing_data_from_and(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		patient.sendPatientData(dataReader.getData(sheetName, rowNumber));
		patient.selectExistingMorbidities();
		patient.selectHabits();
		patient.selectExistingInfections();
		patient.selectPhysicalFitness();
		patient.selectFamilyHistory();
		patient.saveButton();
		logger.info("Patient submits patient form with missing data");

	}

	@When("Error message {string} is displayed and review the following field")
	public void error_message_is_displayed_and_review_the_following_field(String hitErrorMsg) {
		String errorMsg = patient.hitSnagError();
		assertEquals(errorMsg, hitErrorMsg);
		patient.reviewMissingFieldClick();

	}

	@Then("Error message {string} is displayed")
	public void error_message_is_displayed(String errorMsgIncomplete) {
		String errorMsg = patient.errorMsgIncompleteText();
		assertEquals(errorMsg, errorMsgIncomplete);

	}

	@When("Patient submits new patient form with invalid data for textfields from {string} and {int}")
	public void patient_submits_new_patient_form_with_invalid_data_for_textfields_from_and(String sheetName,
			Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		patient.cancelButton();
		patient.newPatientform();
		patient.sendPatientData(dataReader.getData(sheetName, rowNumber));
		patient.selectExistingMorbidities();
		patient.selectHabits();
		patient.selectExistingInfections();
		patient.selectPhysicalFitness();
		patient.selectFamilyHistory();
		patient.saveButton();
		logger.info("Patient submits patient form with missing data");
		patient.reviewInvalidFieldClick();
	}

	@Then("Error message {string} is displayed under textfields")
	public void error_message_is_displayed_under_textfields(String errorMsgInvalidChar) {
		String errorMsg = patient.errorMsgInvalidChar();
		assertEquals(errorMsg, errorMsgInvalidChar);
	}

	@When("Patient submits new patient form with invalid data for DOB from {string} and {int}")
	public void patient_submits_new_patient_form_with_invalid_data_for_dob_from_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		patient.cancelButton();
		patient.newPatientform();
		patient.sendPatientData(dataReader.getData(sheetName, rowNumber));
		patient.selectExistingMorbidities();
		patient.selectHabits();
		patient.selectExistingInfections();
		patient.selectPhysicalFitness();
		patient.selectFamilyHistory();
		patient.saveButton();
		logger.info("Patient submits patient form with missing data");
		patient.reviewInvalidDOBClick();
	
	}

	@Then("Error message {string} is displayed under DOB field")
	public void error_message_is_displayed_under_dob_field(String errorMsgInvalidDOB) {
		String errorMsg = patient.errorMsgInvalidDOB();
		assertEquals(errorMsg, errorMsgInvalidDOB);
	
	}

	@When("Patient submits new patient form entering other for morbidities from {string} and {int}")
	public void patient_submits_new_patient_form_entering_other_for_morbidities_from_and(String sheetName,
			Integer rowNumber) throws InvalidFormatException, IOException {
		patient.cancelButton();
		patient.newPatientform();
		patient.sendPatientData(dataReader.getData(sheetName, rowNumber));
		patient.selectExistingMorbidities();
		patient.selectHabits();
		patient.selectExistingInfections();
		patient.selectPhysicalFitness();
		patient.selectFamilyHistory();
		patient.saveButton();
		logger.info("Patient submits patient form with missing data");
		patient.reviewOtherExisMorClick();
	}

	@Then("Error message {string} is displayed under existing morbidity")
	public void error_message_is_displayed_under_existing_morbidity(String errorMsgOtherExisMor) {
		String errorMsg = patient.errorMsgOtherExisMor();
		assertEquals(errorMsg, errorMsgOtherExisMor);
	
	}

	@When("Patient submits new patient form with valid data from {string} and {int}")
	public void patient_submits_new_patient_form_with_valid_data_from_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		patient.cancelButton();
		patient.newPatientform();
		patient.sendPatientData(dataReader.getData(sheetName, rowNumber));
		patient.selectExistingMorbidities();
		patient.selectHabits();
		patient.selectExistingInfections();
		patient.selectPhysicalFitness();
		patient.selectFamilyHistory();
		patient.saveButton();
		logger.info("Patient submits patient form with missing data");
		patient.selectListView();
	    patient.selectExistPatientView();
		patient.SortDesc();
	}

	@Then("Patient form is successfully created with the success message")
	public void patient_form_is_successfully_created_with_the_success_message() {
		patient.getLastElementText();
		String actualAlertMsg = patient.getalertMsg();
		String expectedAlertMsg = patient.getExpectedMsg();
		assertEquals(actualAlertMsg, expectedAlertMsg);
	}


}
