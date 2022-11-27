Feature: Create Car Function

  Background: User on the login page
    Given User is on the login page

  @wip5
  Scenario Outline: Login as a <userType> - 1
    When User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module
    Then Verify driver cannot see the button
    But that the sale manager and store manager can click Create Car button

    Examples:
      | userType      |
      | Driver        |
      | Sales Manager |
      | Store Manager |

  @wip5
  Scenario: Login as a "Sales Manager" - 2
    When User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    Then User goes to Create Car page and creates a car by filling compulsory fields

  Scenario:
    When User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    Then User goes to Create Car page and enters Compulsory fields without complying with the conditions



