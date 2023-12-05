@ExistingMorbidities
Feature: Validitate Existing Morbidities

  @TS_01ValidateExistingMorbidities-availabletochosen
  Scenario: Validate Existing Morbidities available to chosen
    Given Patient is on available list box of existing morbidities
    When Patient  selects an existing morbidity in the list available
    And clicks the right arrow
    Then Patient should able to see the selected option "High Cholesterol" in the chosen list box

  @TS_02ValidateUndoExistingMorbidities
  Scenario: Validate the Undo button on Existing Morbidities
    Given Patient is on chosen list box of existing morbidities
    When Patient  clicks on undo button
    Then Patient should be able to see the error msg "An option must be selected"

  @TS_03ValidateTheotherTextbox
  Scenario: Validate the Other textbox
    Given Patient is on available list box of existing morbidities
    When Patient selects "other" as an existing morbidity in the list available
    And clicks the right arrow of  existing morbidities listbox
    Then Patient should be able enter the "Sinuscitis" in the text box

  @TS_04ValidateTheAllergyCheckbox
  Scenario: Validate the Allergy Checkbox
    Given Patient is on available list box of existing morbidities
    When Patient selects the allergy check box
    Then Patient should be able enter the text "peanuts" in the text box

  @TS_05ValidateTheotherTextboxinExistingInfections
  Scenario: Validate the Other textbox in Existing Infections
    Given Patient is on available list box of existing morbidities
    When Patient selects an existing infection in the list available
    And clicks the right arrow of  existing Infections listbox
    Then Patient should be able enter the "Pneumonia" in the text box of existing infections

  @TS_06ValidateHabitsOption-availabletochosen
  Scenario: Validate selecting Habits options from available to chosen
    Given Patient  selects a habit in the list available
    When Patient clicks the right arrow
    And Patient selects one more option
    And Patient clicks the right arrow
    Then Patient should able to see the "Alcohol","Drugs" in the chosen list box

  @TS_07ValidatePhysicalFitnessoption-availabletochosen
  Scenario: Validate selecting Physical fitness options from available to chosen
    Given Patient  selects a fitness option in the list available
    When clicks on the right arrow
    Then Patient should able to see the selected option "Yoga" in the fitness chosen list box

  @TS_08ValidateFamilyHistory-moreoptionsavailabletochosen
  Scenario: Validate selecting Family History options more than one from available to chosen
    Given Patient  selects more than one option holding shift from the list available
    When Patient clicks on the right arrow of Family History
    Then Patient should able to see the selected "Diabetes", "Thyroid" in the chosen list box

  @TS_09ValidateFamilyHistory-leftarrowbtn
  Scenario: Validate selecting Family History left arrow from chosen to available
    Given Patient  selects an option holding from the list chosen
    When Patient clicks on the left arrow of Family History
    Then Patient should not be  able to see the selected "Diabetes" in the chosen list box

  @TS_10ValidateFitnessFrequencyDropDown
  Scenario: Validate Fitness Frequency DropDown
    Given Patient is on existing morbidities section
    When Patient  clicks on Fitness Frequency dropdown
    Then Patient should be able to select an option from the Fitness Frequency dropdown

  @TS_11ValidateTheSurgeriesCheckbox
  Scenario: Validate the Surgeries Checkbox
    Given Patient is on existing morbidities section
    When Patient selects the surgeries check box
    Then Patient should be able enter the text "Heart Surgery" in the text box

  @TS_12ValidateImmunizationDropDown
  Scenario: Validate Immunization DropDown
    Given Patient is on existing morbidities section
    When Patient  clicks on Immunization dropdown
    Then Patient should be able to select an option from the Immunization dropdown

  @TS_13ValidateInternationalTravelCheckbox
  Scenario: Validate the International Travel Checkbox
    Given Patient is on existing morbidities section
    When Patient selects the  International Travel check box
    Then Patient should be able enter the "India" in the Enter Country Name text box
