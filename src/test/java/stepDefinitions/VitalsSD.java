package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Vitals;

public class VitalsSD {

	public WebDriver driver;
	Vitals vt = new Vitals();

	@Given("Patient is on Sepsis App Patients page")
	public void patient_is_on_sepsis_app_patients_page() {

	}

	@When("Patient clicks on Current Medication textbox")
	public void patient_clicks_on_current_medication_textbox() {
		vt.MedicationClick();
	}

	@Then("Patient enter {string} in textbox")
	public void patient_enter_in_textbox(String mdvalue) {

		vt.medicatiovalue(mdvalue);
	}

	@When("Patient clicks on Temperature textBox")
	public void patient_clicks_on_temperature_text_box() {
		vt.VitalsTempClick();

	}

	@Then("Patient enter Temperature {string} in textBox")
	public void admin_enter_temperature_in_text_box(String temperature) {
		vt.VitalsTemp(temperature);
	}

	@When("Patient clicks on Heartrate textBox")
	public void patient_clicks_on_Heartrate_text_box() {
		vt.HearrateClick();

	}

	@Then("Patient enter Heart Rate {string} in textBox")
	public void admin_enter_heart_rate_in_text_box(String heartrate) {
		vt.VitalsHeartRate(heartrate);
	}

	@When("Patient clicks on Respiratory Rate textBox")
	public void patient_clicks_on_respiratory_rate_text_box() {
		vt.respiratoryclick();
	}

	@Then("Patient enter Reaspiratory Rate {string} in textBox")
	public void patient_enter_reaspiratory_rate_in_text_box(String respiratoryrate) {
		vt.VitalsRespiratoryRate(respiratoryrate);
	}

	@When("Patient clicks on BP textBox")
	public void patient_clicks_on_bp_text_box() {
		vt.VitalsBPClick();
	}

	@Then("Patient enter BP {string} in textBox")
	public void patient_enter_bp_in_text_box(String bp) {
		vt.VitalsBP(bp);

	}

	@When("Patient clicks on Glucose dropdown")
	public void admin_clicks_on_glucose_dropdown() {
		vt.VitalsGlucoseDropdown();

	}

	@Then("Patient select Glucose from dropdown")
	public void patient_select_glucose_from_dropdown() {
		vt.VitalsGlucoseOption();
	}

	@When("Patient clicks on Glucose Value textBox")
	public void patient_clicks_on_glucose_value_text_box() {
		vt.VitalsGlucoseclick();
	}

	@Then("Patient enter Glucose Value {string} in textBox")
	public void patient_enter_glucose_value_in_text_box(String gv) {
		vt.VitalsGlucoseValue(gv);
	}

	@When("Patient clicks on WBC textBox")
	public void patient_clicks_on_wbc_text_box() {
		vt.wbcclick();
	}

	@Then("Patient enter WBC {string} in textBox")
	public void patient_enter_wbc_in_text_box(String wbc) {
		vt.VitalsWBCcount(wbc);
	}

	@When("Patient clicks on save button")
	public void patient_clicks_on_save_button() throws InterruptedException {
		vt.saveBtnclick();
		Thread.sleep(500);
	}

	@Then("the form should be  saved succesfully by displaying a message")
	public void the_form_should_be_saved_succesfully_by_displaying_a_message() {
        
		//vt.getLastElementText();
		String actualAlertMsg = vt.getalertMsg();
		String expectedAlertMsg = vt.getExpectedMsg();
		assertEquals(actualAlertMsg, expectedAlertMsg);
	}

}
