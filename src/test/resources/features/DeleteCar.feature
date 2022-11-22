Feature: Delete Car
  US: As a 'Sales Manager' and 'Store Manager', I should be able to delete a car (Veli AYDIN)

  Background:
    Given User is on the login page

  #AC-1:

  Scenario Outline: All users can see the delete button by hovering over the three dots at the end of each row
    When User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User hover over three dots at the end of each row
    Then Verify that user can see delete button

    Examples:
      | userType      |
      | Sales Manager |
      | Store Manager |
      | Driver        |