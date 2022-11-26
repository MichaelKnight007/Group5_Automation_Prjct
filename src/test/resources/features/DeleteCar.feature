@deleteCar
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
  6- Delete option c:
  Authorized user can delete multiple vehicle(s) by clicking on the delete button found on the 'Mass Actions' (three dots at the end of the TITLE section of the vehicles), and "... entity was deleted" / "... entities have been deleted successfully" message should be displayed.
  7- When a car is deleted, it must be removed from Fleet-Vehicle page.

  Background:
    Given User is on the login page

  Scenario Outline: AC: 1-2-3-4
    And User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module
    When User hover over the three dots at the end of each row
    Then Verify that user sees Delete button

    When User clicks on the Delete icon
    Then Verify that Delete Confirmation pop up displayed
    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |