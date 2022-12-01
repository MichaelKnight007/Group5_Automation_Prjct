
Feature: User Story :
  As a 'Sales Manager' and 'Store Manager', I should be able to delete a car

  Acceptance Criteria:
  1- All users can see the delete button by hovering over the three dots at the end of each row
  2- "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
  3- "You do not have permission to perform this action." message should be displayed if the driver clicks on "Yes, Delete" button.
  4- Delete option a:
  Authorized user can delete any car, by clicking on the delete button at the end of each row, and "Item deleted" message should be displayed.
  5- Delete option b:
  Authorized user can delete any vehicle from 'General Information' page, by clicking on the 'Delete' button, and "Car deleted" message should be displayed.
  6- When a car is deleted, it must be removed from Fleet-Vehicle page.

  Background:
    Given User is on the login page


  Scenario Outline: AC: 1-2-3-4
    And User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module
    When User hover over the three dots at the end of each row
    Then Verify that user sees Delete button

    When User clicks on the Delete icon
    Then Verify that Delete Confirmation pop up displayed

    When The user clicks on Yes-Delete btn
    Then "<userType>" gets "<message>" message

    Examples:
      | userType      | message                                            |
      | driver        | You do not have permission to perform this action. |
      | sales manager | Item deleted                                       |
      | store manager | Item deleted                                       |


  Scenario Outline: AC-5,6: Delete a car from General Info page
    And User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module

    And The user saves License Plate of the car
    When The user clicks on any row on the VehicleTable page
    Then The user is on the General Information page

    When User clicks on the Delete button
    When The user clicks on Yes-Delete btn
    And The deleted car is also removed from the table

    Examples:
      | userType      |
      | sales manager |
      | store manager |
