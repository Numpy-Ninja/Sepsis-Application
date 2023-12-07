@PatientInformationWithValidandInvalidAndMissingData
Feature: Validating the New Patient form with Valid/Invalid/MissingData

  @TS_01ValidatingtheNewPatientformWithMissingData
    Scenario Outline: Validate the patient information form submission with missing data
    Given Patient is on New patient form
    When Patient submits new patient form with missing data from "<SheetName>" and <Rownumber>
    And Error message "We hit a snag." is displayed and review the following field
    Then Error message "Complete this field." is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      |   PatientDetails    |     2     |
     
  @TS_02ValidatingtheNewPatientformWithInvalidData
    Scenario Outline: Validate the patient information form submission with invalid data
    Given Patient is on same patient form
    When Patient submits new patient form with invalid data for textfields from "<SheetName>" and <Rownumber>
    Then Error message "Please enter only Alphabets" is displayed under textfields
    
    
    Examples: 
      | SheetName        | Rownumber |
      | PatientDetails      |     3     |
      
  @TS_02ValidatingtheNewPatientformWithInvalidData
    Scenario Outline: Validate the patient information form submission with invalid data
    Given Patient is on same patient form
    When Patient submits new patient form with invalid data for DOB from "<SheetName>" and <Rownumber>
    Then Error message "DOB cannot be in future.pls change it to sometime past." is displayed under DOB field
    
    
    Examples: 
      | SheetName        | Rownumber |
      | PatientDetails      |     4     |
  
  @TS_02ValidatingtheNewPatientformWithInvalidData
    Scenario Outline: Validate the patient information form submission with invalid data
    Given Patient is on same patient form
    When Patient submits new patient form entering other for morbidities from "<SheetName>" and <Rownumber>
    Then Error message "Please explain only other existing morbidities!" is displayed under existing morbidity
    
    
    Examples: 
      | SheetName        | Rownumber |
      | PatientDetails      |     5    |
      
  @TS_03ValidatingtheNewPatientformWithValidData  
  Scenario Outline: Validate attendance form submission with valid data
    Given Patient is on same patient form
    When Patient submits new patient form with valid data from "<SheetName>" and <Rownumber>
    Then Patient form is successfully created with the success message "Patient \"PT-<int>\" was created."
    
    Examples: 
      | SheetName        | Rownumber |
      | PatientDetails      |     6     |  