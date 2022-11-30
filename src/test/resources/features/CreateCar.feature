Feature: Create Car Function

  Background: User on the login page
    Given User is on the login page


 # @wip5
  Scenario Outline: Login as a <userType> - 1
    When User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module
    Then Verify driver cannot see the button


    Examples:
      | userType |
      | Driver   |



  # @wip5
  Scenario Outline: Login as a <userType> - 1
    When User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module
    Then that the sale manager and store manager can click Create Car button

    Examples:
      | userType      |
      | Sales Manager |
      | Store Manager |


  # @wip5
  Scenario: Login as a "Sales Manager" - 2
    When User logs in as a "Store Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User goes to Create Car page
    Then User creates a car by filling compulsory fields

  # @wip5
  Scenario: Login as a "Sales Manager" - 2
    When User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User goes to Create Car page
    Then User cannot create a car without filling compulsory fields

   @wip5
  Scenario:
    When User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User goes to Create Car page
    Then User enters Compulsory fields without complying with the conditions

  Scenario:
    When User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User goes to Create Car page
    Then User can select ‘Vehicle Model’ and ‘Vehicle Make’ from the list


  Scenario: Login as a "Sales Manager" - 2
    When User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User goes to Create Car page
    And User creates a car by filling compulsory fields
    Then User can see newly created car in ’Fleet-Vehicle’ table