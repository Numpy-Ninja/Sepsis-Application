@PatientInformationWithValidandInvalidAndMissingData
Feature: Validating the New Patient form with Valid/Invalid/MissingData

  @TS_01ValidatingtheNewPatientformWithMissingData
    Scenario Outline: Validate the patient information form submission with missing data
    Given Patient is on New patient form for entering patient details
    When Patient submits new patient form with missing data from "<SheetName>" and <Rownumber>
    And Error message "We hit a snag." is displayed and review the following field
    Then Error message "Complete this field." is displayed
    
    Examples: 
      | SheetName        | Rownumber |
      |   PatientDetails    |     0     |
      
   @TS_02ValidatingtheNewPatientformWithInvalidData
    Scenario Outline: Validate the patient information form submission with invalid phonefield
    Given Patient is on same patient form
    When Patient submits new patient form with invalid data for phone field from "<SheetName>" and <Rownumber>
    Then Error message "US phone numbers should be in this format: (999) 999-9999." is displayed under phone field
    
    
    Examples: 
      | SheetName        | Rownumber |
      | PatientDetails      |     1     |
     
  @TS_03ValidatingtheNewPatientformWithInvalidCharacter
    Scenario Outline: Validate the patient information form submission with invalid character
    Given Patient is on same patient form
    When Patient submits new patient form with invalid data for textfields from "<SheetName>" and <Rownumber>
    Then Error message "Please enter only Alphabets" is displayed under textfields
    
    
    Examples: 
      | SheetName        | Rownumber |
      | PatientDetails      |     2     |
      
   @TS_04ValidatingtheNewPatientformWithInvalidBPdata
    Scenario Outline: Validate the patient information form submission with invalid data for BP
    Given Patient is on same patient form
    When Patient submits new patient form with invalid data for BP field from "<SheetName>" and <Rownumber>
    Then Error message "BP should be in Systolic and Diastolic" is displayed under BP field 
    
    
    Examples: 
      | SheetName        | Rownumber |
      | PatientDetails      |     3     |   
      
  @TS_05ValidatingtheNewPatientformWithInvalidDOB
    Scenario Outline: Validate the patient information form submission with invalid data
    Given Patient is on same patient form
    When Patient submits new patient form with invalid data for DOB from "<SheetName>" and <Rownumber>
    Then Error message "DOB cannot be in future.pls change it to sometime past." is displayed under DOB field
    
    
    Examples: 
      | SheetName        | Rownumber |
      | PatientDetails      |     4     |
  
  @TS_06ValidatingtheNewPatientformWithInvalidExisMorb
    Scenario Outline: Validate the patient information form submission with invalid data
    Given Patient is on same patient form
    When Patient submits new patient form entering other for morbidities from "<SheetName>" and <Rownumber>
    Then Error message "Please explain only other existing morbidities!" is displayed under existing morbidity
    
    
    Examples: 
      | SheetName        | Rownumber |
      | PatientDetails      |     5    |
      
  @TS_07ValidatingtheNewPatientformWithInValidEmail 
  Scenario Outline: Validate patient information form submission with invalid data
    Given Patient is on same patient form
    When Patient submits new patient form with invalid email from "<SheetName>" and <Rownumber>
    Then Error message "You have entered an invalid format." is displayed under email
    
    Examples: 
      | SheetName        | Rownumber |
      | PatientDetails      |     6   |  
      
  @TS_08ValidatingtheNewPatientformWithValidDataForSepsisStatus
  Scenario Outline: Validate patient information form submission with valid data for risk of Sepsis
    Given Patient is on New patient form for entering patient info
    When Patient submits new patient form with valid data from "<SheetName>" and <Rownumber>
    Then Patient can see the risk of sepsis status to be "<riskOfSepsis>" on the saved form
    
    Examples: 
      | SheetName        | Rownumber | riskOfSepsis |
      #| PatientDetails    |    7     | LOW       |
      #| PatientDetails    |   8      | LOW       |
      | PatientDetails    |    9     | Medium    |
      #| PatientDetails    |   10     | Medium    |   
      | PatientDetails    |   11     |   High     |
      #| PatientDetails    |   12     |   High    |
      
  @TS_09ValidatingtheNewPatientformWithValidDataForCritical
  Scenario Outline: Validate attendance form submission with valid data for Critical risk
    Given Patient is on same patient form
    When Patient submits new patient form with valid data for critical from "<SheetName>" and <Rownumber>
    Then Patient can see the risk of sepsis field to be "Critical" on the saved patient form
    
    Examples: 
      | SheetName        | Rownumber |
      | PatientDetails    |    13   | 
      
 
      
       
    