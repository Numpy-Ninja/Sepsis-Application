@NewPatientPersonalInformation
Feature: Validating the New Patient Personal Information
 

  Background: The Patient is logged in to Saleforce app(Sepsis)
    Given The patient is on Signin page of salesforce application
    When The patient enter valid "username" and "password"
    And The user click on login button
    Then The user redirected to SalesForceHomepage

  @TS_01_ValidateFirstNameWithValidData
  Scenario: Validating the FirstName
    Given patient is on patient Personal Information page
    When Patient enters the First Name in "FirstName"
    And Patient enters the Last Name in "LastName"
    Then after filling the form with manadatory fileds and saving,the First Name status should be "status"
