Feature: Common Features

  #Login
  Background: User on the login page
    Given User is on the login page

  Scenario: Driver logs in with valid credentials
    When "Driver" logs in
    Then Verify that the user is on "Quick Launchpad" page

  Scenario: Sales Manager logs in with valid credentials
    When "Sales Manager" logs in
    Then Verify that the user is on "Dashboard" page

  Scenario: Driver logs in with valid credentials
    When "Store Manager" logs in
    Then Verify that the user is on "Dashboard" page

  Scenario Outline: Login as a <userType>
    When User logs in as a "<userType>"
    Then Verify that the user is on "<pageSubTitle>" page

    Examples:
      | userType      | pageSubTitle    |
      | Driver        | Quick Launchpad |
      | Sales Manager | Dashboard       |
      | Store Manager | Dashboard       |

  # goToModule
  Scenario: Go to "Vehicles" module
    When "Store Manager" logs in
    And User goes to "Fleet" module and "Vehicles" sub-module
    Then Verify that the user is on "All Cars" module

    # Select Car
  Scenario: Select a car
    When "Store Manager" logs in
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User selects a car
    # ToDo : Then Verify that the user select car