@TRAD-1005
Feature: User should be able to see detailed information of a specific vehicle
  Acceptance Criteria:
  1- User can see the "General Information" page by clicking on any vehicle (row), under 'Fleet-Vehicle' module
  2- User can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row, under 'Fleet-Vehicle' module
  3- Sales manager and store manager should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
  4- Driver shouldn't see "Add Event", "Edit" and "Delete" buttons
  5- Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same


  AC:TRAD-905--> User can see the "General Information" page by clicking on any vehicle (row)
  Background:
  Given User is on the login page

  @TRAD-1000
  Scenario: AC1- General Info page by clicking any row
    And User logs in as a "Driver"
    And User goes to "Fleet" module and "Vehicles" sub-module

    When The user clicks on any row on the VehicleTable page
    Then The user is on the General Information page

  @TRAD-1001
    Scenario: AC2- User can see the "General Information" page clicking on the "Eye (View)" icon
    And User logs in as a "Driver"
    And User goes to "Fleet" module and "Vehicles" sub-module
    When User hover over the three dots at the end of each row
    And user clicks on Eye (View) icon
    Then  The user is on the General Information page

  @TRAD-1002
  Scenario Outline: AC3-Sales manager and store manager should see "Edit", "Delete" and "Add Event" buttons
    And User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module
    When The user clicks on any row on the VehicleTable page
    Then The user can see "Edit", "Delete" and "Add Event" buttons

    Examples:
      | userType |
      | Sales Manager |
      | Store Manager |

  @TRAD-1003
  Scenario Outline: AC4-Driver shouldn't see "Edit", "Delete" and "Add Event" buttons
    And User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module

    When The user clicks on any row on the VehicleTable page
    Then The user can't see "Edit", "Delete" and "Add Event" buttons

    Examples:
      | userType |
      | Driver   |

  @TRAD-1004
  Scenario: AC5- Vehicle information should be the same
    And User logs in as a "Driver"
    And User goes to "Fleet" module and "Vehicles" sub-module
    When The user saves car info of any row randomly
    And The user clicks on the same row on the VehicleTable pagea
    Then All the car info must be the same as in the General Info page
