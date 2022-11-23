Feature: Create Car Function

  Background: User on the login page
    Given User is on the login page

  @wip5
  Scenario Outline: Login as a <userType>
    When User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module
    Then Verify driver cannot see the button
    But that the sale manager and store manager can click Create Car button

    Examples:
      | userType      |
      | Driver        |
      | Sales Manager |
      | Store Manager |


  Scenario: Login as a "Sales Manager"
    When User logs in as a "Sales Manager"
    Then Verify that the user is on "Dashboard" page
