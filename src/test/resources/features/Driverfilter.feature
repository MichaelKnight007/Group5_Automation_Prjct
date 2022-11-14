
Feature: As a user, I should be able to use Driver filter under Fleet-Vehicle page

  Background:
  Given User logs i as a Salesmanager
    And User shoul go to dashboard page
    And User clicks fleet menu
    And User clicks vehicles page under fleet menu
    And User clicks Manage Filter dropdown
    And User select Driver option
    And User clicks Driver All dropdown
    And User clicks Contains dropdown



    Scenario: "Driver" filter has the methods below:
    Contains
    Does Not Contain
    Is Equal To
    Starts With
    Ends With
    Is Any Of
    Is Not Any Of
    Is Empty
    Is Not Empty

      When User clicks Contains dropdown
      Then User should use all options under Driver Filter Menu
