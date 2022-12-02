Feature: "Create Car" Function Test

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
  Scenario: User creates a car by filling compulsory fields
    When User logs in as a "Store Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User goes to Create Car page
    Then User creates a car by filling compulsory fields

  # @wip5
  Scenario: User tries to create a car by not filling compulsory fields
    When User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User goes to Create Car page
    Then User cannot create a car without filling compulsory fields

   @wip5
  Scenario: User enters invalid data to the compulsory fields
    When User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User goes to Create Car page
    Then User enters Compulsory fields without complying with the conditions


 # @wip5
  Scenario: User enters invalid data to the Optional fields
    When User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User goes to Create Car page
    Then User enters Optional fields without complying with the conditions

 # @wip5
  Scenario: User selects ‘Vehicle Model’ and ‘Vehicle Make’ from the list
    When User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User goes to Create Car page
    Then User can select ‘Vehicle Model’ and ‘Vehicle Make’ from the list

 # @wip5
  Scenario: User sees newly created car in ’Fleet-Vehicle’ table
    When User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User goes to Create Car page
    And User creates a car by filling compulsory fields
    Then User can see newly created car in ’Fleet-Vehicle’ table