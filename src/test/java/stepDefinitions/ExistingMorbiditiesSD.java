package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.ExistingMorbidities;

public class ExistingMorbiditiesSD {

	ExistingMorbidities existingMorbidities = new ExistingMorbidities();
	static String expectedSelectedMorbidity;
	static String expectedErrorMsg;
	static String expectedHbtErrorMsg;
	static String expectedHbtErrorMsg1;
	static String expectedFamhistoryMsg;
	static String expectedFamhistoryMsg1;
	static String expectedFHOption;

	@Given("Patient is on available list box of existing morbidities")
	public void patient_is_on_available_list_box_of_existing_morbidities() {

	}

	@When("Patient  selects an existing morbidity in the list available")
	public void patient_selects_an_existing_morbidity_in_the_list_available() {

		existingMorbidities.selectExistingMorbidity();
	}

	@And("clicks the right arrow")
	public void clicks_the_right_arrow() {
		existingMorbidities.ClickonRightarrow();

	}

	@Then("Patient should able to see the selected option {string} in the chosen list box")
	public void patient_should_able_to_see_the_selected_option_in_the_chosen_list_box(
			String expectedSelectedMorbidity) {
		String actualSelectedMorbidity = existingMorbidities.getText();

		assertEquals(actualSelectedMorbidity, expectedSelectedMorbidity);

	}

	@Given("Patient is on chosen list box of existing morbidities")
	public void patient_is_on_chosen_list_box_of_existing_morbidities() {

	}

	@When("Patient  clicks on undo button")
	public void patient_clicks_on_undo_button() {
		existingMorbidities.ClickOnUndo();

	}

	@Then("Patient should be able to see the error msg {string}")
	public void patient_should_be_able_to_see_the_error_msg(String expectedErrorMsg) {
		String actualErrorMsg = existingMorbidities.validateErrormsg();
		assertEquals(actualErrorMsg, expectedErrorMsg);

	}

	@When("Patient selects {string} as an existing morbidity in the list available")
	public void patient_selects_as_an_existing_morbidity_in_the_list_available(String string) {
		existingMorbidities.ValidateExistMorbidityOther();
	}

	@When("clicks the right arrow of  existing morbidities listbox")
	public void clicks_the_right_arrow_of_existing_morbidities_listbox() {
		existingMorbidities.ClickonRightarrow();
	}

	@Then("Patient should be able enter the {string} in the text box")
	public void patient_should_be_able_enter_the_in_the_text_box(String morbidity) {
		existingMorbidities.validateOtherTextbox(morbidity);
	}

	@When("Patient selects the allergy check box")
	public void patient_selects_the_allergy_check_box() {
		existingMorbidities.clickAllergyBx();

	}

	@Then("Patient should be able enter the text {string} in the text box")
	public void patient_should_be_able_enter_the_text_in_the_text_box(String allergy) {
		existingMorbidities.sendTextBx(allergy);
	}

	@When("Patient selects an existing infection in the list available")
	public void patient_selects_as_an_existing_infection_in_the_list_available() {
		existingMorbidities.ValidateExistInfOther();
	}

	@And("clicks the right arrow of  existing Infections listbox")
	public void clicks_the_right_arrow_of_existing_infections_listbox() {
		existingMorbidities.clickRightarrow();
	}

	@Then("Patient should be able enter the {string} in the text box of existing infections")
	public void patient_should_be_able_enter_the_in_the_text_box_of_existing_infections(String infection) {
		existingMorbidities.validateOtherTextboxExInf(infection);
	}

	@Given("Patient  selects a habit in the list available")
	public void patient_selects_a_habit_in_the_list_available() {
		existingMorbidities.selectHabit();
	}

	@When("Patient clicks the right arrow")
	public void patient_clicks_the_right_arrow() {
		existingMorbidities.ClickonHbtRightarrow();
	}

	@And("Patient selects one more option")
	public void patient_selects_one_more_option() {
		existingMorbidities.selectHabitopt();
	}

	@Then("Patient should able to see the {string},{string} in the chosen list box")
	public void patient_should_able_to_see_the_in_the_chosen_list_box(String expectedHbtErrorMsg,
			String expectedHbtErrorMsg1) {
		String actualMsgopt1 = existingMorbidities.HbtgetText();
		String actualMsgopt2 = existingMorbidities.Hbt1getText();
		assertEquals(actualMsgopt1, expectedHbtErrorMsg);
		assertEquals(actualMsgopt2, expectedHbtErrorMsg1);
	}

	@Given("Patient  selects a fitness option in the list available")
	public void patient_selects_a_fitness_option_in_the_list_available() {
		existingMorbidities.selectPFOption();
	}

	@When("clicks on the right arrow")
	public void clicks_on_the_right_arrow() {
		existingMorbidities.clickRightArrow();
	}

	@Then("Patient should able to see the selected option {string} in the fitness chosen list box")
	public void patient_should_able_to_see_the_selected_option_in_the_fitness_chosen_list_box(
			String expectedfitnesOption) {
		String actualfitnessOption = existingMorbidities.fitnessOptgetText();

		assertEquals(actualfitnessOption, expectedfitnesOption);

	}

	@Given("Patient  selects more than one option holding shift from the list available")
	public void patient_selects_more_than_one_option_holding_shift_from_the_list_available() {
		existingMorbidities.SelMultipleOptions();
	}

	@When("Patient clicks on the right arrow of Family History")
	public void Patient_clicks_on_the_right_arrow_of_Family_History() {
		existingMorbidities.ClkFamHisRightArrow();
	}

	@Then("Patient should able to see the selected {string}, {string} in the chosen list box")
	public void patient_should_able_to_see_the_selected_in_the_chosen_list_box(String expectedFamhistoryMsg,
			String expectedFamhistoryMsg1) {
		String actualMsgopt1 = existingMorbidities.FamHistoryOption1GetTxt();
		String actualMsgopt2 = existingMorbidities.FamHistoryOption2GetTxt();
		assertEquals(actualMsgopt1, expectedFamhistoryMsg);
		assertEquals(actualMsgopt2, expectedFamhistoryMsg1);
	}

	@Given("Patient  selects an option holding from the list chosen")
	public void patient_selects_an_option_holding_from_the_list_chosen() {
		existingMorbidities.ValidateFamHisLarrowbtn();
	}

	@When("Patient clicks on the left arrow of Family History")
	public void patient_clicks_on_the_left_arrow_of_family_history() {
		existingMorbidities.ClkFHLftArrow();
	}

	@Then("Patient should not be  able to see the selected {string} in the chosen list box")
	public void patient_should_not_be_able_to_see_the_selected_in_the_chosen_list_box(String expectedFHOption) {
		String actualFHOption = existingMorbidities.FamHistoryOption2GetTxt();
		assertNotEquals(actualFHOption, expectedFHOption);
	}

	@Given("Patient is on existing morbidities section")
	public void patient_is_on_existing_morbidities_section() {
	}

	@When("Patient  clicks on Fitness Frequency dropdown")
	public void patient_clicks_on_fitness_frequency_dropdown() {
		existingMorbidities.ClickFitnessDropdown();
	}

	@Then("Patient should be able to select an option from the Fitness Frequency dropdown")
	public void patient_should_be_able_to_select_an_option_from_the_fitness_frequency_dropdown() {
		existingMorbidities.FitnessDropdownOption();
	}

	@When("Patient selects the surgeries check box")
	public void patient_selects_the_surgeries_check_box() {
		//existingMorbidities.clickSurgeryCkbx();
	}

	@Then("Patient should be able to enter the text {string} in the textbox")
	public void patient_should_be_able_to_enter_the_text_in_the_textbox(String surgery) throws InterruptedException {
		//existingMorbidities.surgeryTxtbx(surgery);
	}

	@When("Patient  clicks on Immunization dropdown")
	public void patient_clicks_on_immunization_dropdown() {
		existingMorbidities.ClickImmunizationDropdown();
	}

	@Then("Patient should be able to select an option from the Immunization dropdown")
	public void patient_should_be_able_to_select_an_option_from_the_immunization_dropdown() {
		existingMorbidities.ImmuneDropdownOption();
	}

	@When("Patient selects the  International Travel check box")
	public void patient_selects_the_international_travel_check_box() {
		existingMorbidities.clickIntTravelChkbx();

	}

	@Then("Patient should be able enter the {string} in the Enter Country Name text box")
	public void patient_should_be_able_enter_the_in_the_enter_country_name_text_box(String country) {
		existingMorbidities.IntTravelTxtBx(country);
	}

}
