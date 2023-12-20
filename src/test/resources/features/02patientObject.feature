@NewPatientInformation
Feature: Validating the New Patient information

  @TS_01_ValidatePersonalInfo
  Scenario Outline: Validating the PersonalInfo
    Given Patient is on New patient form
    When Patient enters "<FirstName>","<LastName>",Gender, Race, "<DOB>" and  "<InsuranceDetails>" on personal information
    Then Patient can see the "<FirstName>","<LastName>","<DOB>","<InsuranceDetails>"and other details entered on personal information
    
    
    Examples:
       |FirstName | LastName | DOB | InsuranceDetails |
       |Kelly | Rob | 11/1/2023 | atena4656 |
       
  @TS_02_ValidateContactInfo
  Scenario Outline: Validating the contactinfo
    Given Patient is on same patient form
    When Patient enters the "<phoneNo>" , "<emailAddress>", "<country>", "<street>","<city>" and "<zip>" on contact information
    Then Patient can see the "<phoneNo>" , "<emailAddress>", "<country>", "<street>","<city>" and "<zip>" entered on contact information
    
    
    Examples:
    | phoneNo | emailAddress | country | street | city | zip |
    |815-456-9999 | numpyninjaworkforce@gmail.com| United States | Egmore St | Bayarea  |77433|

  @TS_03_ValidateEmergencycontact
  Scenario Outline: Validating the EmergencyContact
    Given Patient is on same patient form
    When Patient enters "<FullName>" and "<EmergencyContactNumber>"
    Then Patient can see the "<FullName>" and "<EmergencyContactNumber>"entered on emergency contact info
    
    
    Examples:
       |FullName | EmergencyContactNumber | 
       |Kiya| 716-456-7890 | 
 
 
 @TS_04_ValidateProviderInformation
  Scenario Outline: Validating the ProviderInformation
    Given Patient is on same patient form
    When Patient enters "<DoctorsName>" and "<DoctorsContactNumber>" and "<ClinicName>" and "<DoctorsEmail>"
    Then Patient can see the "<DoctorsName>" and "<DoctorsContactNumber>" and "<ClinicName>" and "<DoctorsEmail>" entered on provider information
    
    
    Examples:
       |DoctorsName | DoctorsContactNumber | ClinicName | DoctorsEmail |
       |Klein| 321-456-7890 | BrightClinic | numpyninjaworkforce@gmail.com |
 
  @TS_05_ValidateMedicalHistory
  Scenario Outline: Validating the EmergencyContact
    Given Patient is on same patient form
    When Patient enters "<HeightINcm>" and "<WeightinKgs>" on medical history
    Then Patient can see the "<HeightINcm>" and "<WeightinKgs>" entered on medical history
    
    
    Examples:
       |HeightINcm | WeightinKgs | 
       |12.00| 60 | 
       
       
   