@NewPatientInformation
Feature: Validating the New Patient information
 

  @TS_01_ValidateEmergencycontact
  Scenario Outline: Validating the EmergencyContact
    Given Patient is on New patient form
    When Patient enters "<FullName>" and "<EmergencyContactNumber>"
    Then Patient can see the "<FullName>" and "<EmergencyContactNumber>"entered on emergency contact info
    
    
    Examples:
       |FullName | EmergencyContactNumber | 
       |Kiya| 123-456-7890 | 
 
 
 @TS_02_ValidateProviderInformation
  Scenario Outline: Validating the ProviderInformation
    Given Patient is on same patient form
    When Patient enters "<DoctorsName>" and "<DoctorsContactNumber>" and "<ClinicName>" and "<DoctorsEmail>"
    Then Patient can see the "<DoctorsName>" and "<DoctorsContactNumber>" and "<ClinicName>" and "<DoctorsEmail>" entered on provider information
    
    
    Examples:
       |DoctorsName | DoctorsContactNumber | ClinicName | DoctorsEmail |
       |Klein| 321-456-7890 | BrightClinic | klein@gmail.com |
 
  @TS_01_ValidateMedicalHistory
  Scenario Outline: Validating the EmergencyContact
    Given Patient is on same patient form
    When Patient enters "<HeightINcm>" and "<WeightinKgs>" on medical history
    Then Patient can see the "<HeightINcm>" and "<WeightinKgs>" entered on medical history
    
    
    Examples:
       |HeightINcm | WeightinKgs | 
       |12.00| 60 | 
       
  @TS_01_ValidatePersonalInfo
  Scenario Outline: Validating the PersonalInfo
    Given Patient is on same patient form
    When Patient enters "<FirstName>" and "<LastName>" Gender and DOB on personal information
    Then Patient can see the "<FirstName>" and "<LastName>" and other details entered on personal information
    
    
    Examples:
       |FirstName | LastName | 
       |Kelly| Rob | 