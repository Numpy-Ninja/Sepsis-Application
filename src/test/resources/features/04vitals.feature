@Vitals
Feature: Validating Medication and Vitals Information

  @TS_02Medication
  Scenario: The Patient is logged in to Saleforce app(Sepsis)
    Given Patient is on Sepsis App Patients page
    When Patient clicks on Current Medication textbox
    Then Patient enter "Vitamin D" in textbox

  @TS_03Temparature
  Scenario: Validate Temperature
    Given Patient is on Sepsis App Patients page
    When Patient clicks on Temperature textBox
    Then Patient enter Temperature "98.8" in textBox

  @TS_04HeartRate
  Scenario: Validate Heart Rate
    Given Patient is on Sepsis App Patients page
    When Patient clicks on Heartrate textBox
    Then Patient enter Heart Rate "90" in textBox

  @TS_05RespiratoryRate
  Scenario: Validate Respiratory Rate
    Given Patient is on Sepsis App Patients page
    When Patient clicks on Respiratory Rate textBox
    Then Patient enter Reaspiratory Rate "15" in textBox

  @TS_06BP
  Scenario: Validate BP
    Given Patient is on Sepsis App Patients page
    When Patient clicks on BP textBox
    Then Patient enter BP "110/80" in textBox

  @TS_07Glucose
  Scenario: Validate Glucose
    Given Patient is on Sepsis App Patients page
    When Patient clicks on Glucose dropdown
    Then Patient select Glucose from dropdown

  @TS_08GlucoseValue
  Scenario: Validate Glucose Value
    Given Patient is on Sepsis App Patients page
    When Patient clicks on Glucose Value textBox
    Then Patient enter Glucose Value "100" in textBox

  @TS_09WBC
  Scenario: Validate WBC
    Given Patient is on Sepsis App Patients page
    When Patient clicks on WBC textBox
    Then Patient enter WBC "3000" in textBox

  @TS_10ValidateSaveButton
  Scenario: Validate Save Button
    Given Patient is on Sepsis App Patients page
    When Patient clicks on save button
    Then the form should be  saved succesfully by displaying a message 
    