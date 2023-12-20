package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.awaitility.Awaitility;

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
	String patientId;
	PatientDataReader dataReader = new PatientDataReader();

	@Given("Patient is on New patient form for entering patient details")
	public void patient_is_on_new_patient_form_for_entering_patient_details() {
		// patient.succmsgCloseIcon();
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

	@When("Patient submits new patient form with invalid data for phone field from {string} and {int}")
	public void patient_submits_new_patient_form_with_invalid_data_for_phone_field_from_and(String sheetName,
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
		logger.info("Patient submits patient form with invalid data");
		patient.reviewInvalidPhoneFieldClick();
	}

	@Then("Error message {string} is displayed under phone field")
	public void error_message_is_displayed_under_phone_field(String errorMsgInvalidPh) {
		String errorMsg = patient.errorMsgInvalidPhonenumber();
		assertEquals(errorMsg, errorMsgInvalidPh);

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
		logger.info("Patient submits patient form with invalid data");
		patient.reviewInvalidFieldClick();
	}

	@Then("Error message {string} is displayed under textfields")
	public void error_message_is_displayed_under_textfields(String errorMsgInvalidChar) {
		String errorMsg = patient.errorMsgInvalidChar();
		assertEquals(errorMsg, errorMsgInvalidChar);
	}

	@When("Patient submits new patient form with invalid data for BP field from {string} and {int}")
	public void patient_submits_new_patient_form_with_invalid_data_for_BP_field_from_and(String sheetName,
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
		logger.info("Patient submits patient form with invalid data");
		patient.reviewInvalidBPFieldClick();
	}

	@Then("Error message {string} is displayed under BP field")
	public void error_message_is_displayed_under_bp_field(String errorMsgInvalidBP) {
		String errorMsg = patient.errorMsgInvalidBP();
		assertEquals(errorMsg, errorMsgInvalidBP);
	}

	@When("Patient submits new patient form with invalid data for DOB from {string} and {int}")
	public void patient_submits_new_patient_form_with_invalid_data_for_dob_from_and(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		patient.cancelButton();
		patient.newPatientform();
		patient.sendPatientData(dataReader.getData(sheetName, rowNumber));
		patient.selectExistingMorbidities();
		patient.selectHabits();
		patient.selectExistingInfections();
		patient.selectPhysicalFitness();
		patient.selectFamilyHistory();
		patient.saveButton();
		logger.info("Patient submits patient form with invalid data");
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
		logger.info("Patient submits patient form with invalid data");
		patient.reviewOtherExisMorClick();
	}

	@Then("Error message {string} is displayed under existing morbidity")
	public void error_message_is_displayed_under_existing_morbidity(String errorMsgOtherExisMor) {
		String errorMsg = patient.errorMsgOtherExisMor();
		assertEquals(errorMsg, errorMsgOtherExisMor);

	}

	@When("Patient submits new patient form with invalid email from {string} and {int}")
	public void patient_submits_new_patient_form_with_invalid_email_from_and(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		patient.cancelButton();
		patient.newPatientform();
		patient.sendPatientData(dataReader.getData(sheetName, rowNumber));
		patient.selectExistingMorbidities();
		patient.selectHabits();
		patient.selectExistingInfections();
		patient.selectPhysicalFitness();
		patient.selectFamilyHistory();
		patient.saveButton();
		logger.info("Patient submits patient form with invalid data");
		patient.reviewInvalidEmailClick();

	}

	@Then("Error message {string} is displayed under email")
	public void error_message_is_displayed_under_email(String errorMsgInvalidEmail) {
		String errorMsg = patient.errorMsgInvalidEmail();
		assertEquals(errorMsg, errorMsgInvalidEmail);
		patient.cancelButton();
	}

	@Given("Patient is on New patient form for entering patient info")
	public void patient_is_on_new_patient_form_for_entering_patient_info() {
		logger.info("Patient is on new form");

	}

	@When("Patient submits new patient form with valid data from {string} and {int}")
	public void patient_submits_new_patient_form_with_valid_data_from_and(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		patient.patientObject_select();
		patient.newPatientform();
		patient.sendPatientData(dataReader.getData(sheetName, rowNumber));
		patient.selectExistingMorbiditiesNone();
		patient.selectHabits();
		patient.selectExistingInfections();
		patient.selectPhysicalFitness();
		patient.selectFamilyHistory();
		patient.saveButton();
		logger.info("Patient submits patient form with valid data");
		//patientId = patient.getPatientIdFromSaveSuccessMsg();
		patient.succmsgCloseIcon();
		//patient.patientObject_select();
		//patient.selectListView();
		//patient.selectExistPatientView();
		//patient.getTableViewOfExisPatients();

	}

	@Then("Patient can see the risk of sepsis status to be {string} on the saved form")
	public void patient_can_see_the_risk_of_sepsis_status_to_be_on_the_saved_form(String riskOfSepsis) throws InterruptedException {
//		Awaitility.await().atMost(Duration.ofSeconds(5)).until(() -> {
//			String lastPatientId = patient.getLastElementText();
//			String sepsisStatus = patient.getSepsisRisk();
//			System.out.println(sepsisStatus);
//			return riskOfSepsis.equalsIgnoreCase(sepsisStatus) && patientId.equalsIgnoreCase(lastPatientId);
//		});
		//String lastPatientId = patient.getLastElementText();
		Thread.sleep(2000);

		String sepsisStatus = patient.getSepsisRisk();
		System.out.println(sepsisStatus);
		assertEquals(sepsisStatus, riskOfSepsis);
		
	}

	@When("Patient submits new patient form with valid data for critical from {string} and {int}")
	public void patient_submits_new_patient_form_with_valid_data_for_critical_from_and(String sheetName,
			Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		patient.patientObject_select();
		patient.newPatientform();
		Thread.sleep(2000);
		patient.sendPatientData(dataReader.getData(sheetName, rowNumber));
		patient.selectExistingMorbidities();
		patient.selectHabits();
		patient.selectExistingInfections();
		patient.selectPhysicalFitness();
		patient.selectFamilyHistory();
		patient.saveButton();
		logger.info("Patient submits patient form with valid data");
		//patientId = patient.getPatientIdFromSaveSuccessMsg();
		patient.succmsgCloseIcon();

	}

	@Then("Patient can see the risk of sepsis field to be {string} on the saved patient form")
	public void patient_can_see_the_risk_of_sepsis_field_to_be_on_the_saved_patient_form(String riskOfSepsisC) throws InterruptedException {
//		Awaitility.await().atMost(Duration.ofSeconds(5)).until(() -> {
//			String lastPatientId = patient.getLastElementText();
//			String sepsisStatus = patient.getSepsisRisk();
//			System.out.println(sepsisStatus);
//			return riskOfSepsisC.equalsIgnoreCase(sepsisStatus) && patientId.equalsIgnoreCase(lastPatientId);
//		});
		Thread.sleep(2000);
		String sepsisStatus = patient.getSepsisRisk();
		System.out.println(sepsisStatus);
		assertEquals(sepsisStatus, riskOfSepsisC);
	}

}
