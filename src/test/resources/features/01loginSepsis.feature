@Login
Feature: SalesforceLoginSepsisapp

  @TS_01LoginPage
  Scenario: Validate loginPage
    Given The patient is on Signin page of salesforce application
    When The patient enter valid "username" and "password"
    And The user click on login button
    Then The user redirected to SalesForceHomepage
