Feature: User Story :
  As a Store Manager and Sales Manager, I should be able to add an event
  Acceptance Criteria:
  1- User can access the "Add Event" page from the "General Information" page
  (by clicking on any vehicle/row under Fleet-Vehicle module)
  2- Sales Manager and Store manager can see "Add Event" button, but Driver can NOT see "Add Event" button
  3- After clicking on "Add event" button, "Add Event" page should pop up.
  4- Compulsory fields are shown as below:
  Title
  Owner
  Organizer display name
  Organizer email
  Start Date
  End Date
  5- If any compulsory field is not filled, "This value should not be blank." message should be displayed after clicking on save button.

  Background: User is on "Add Event" page
    When User is on the login page

  Scenario Outline: User should be able to add an event
    #AC : 1-2-3-4
    And User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module
    When User clicks any Vehicle Row under All Cars menu
    Then Verify that the user is on General Information page

    And User clicks on Add Event button
    Then Verify that the user is on the Add Event page

    Then Verify that compulsory fields are shown as below:
      | Title                  |
      | Owner                  |
      | Organizer display name |
      | Organizer email        |
      | Start                  |
      | End                    |

    Examples:
      | userType      |
      | Sales Manager |
      | Store Manager |

  Scenario Outline: User shouldn't be able to add an event without filling the compulsory fields
    #AC : 5
    And User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    When User clicks any Vehicle Row under All Cars menu
    And User clicks on Add Event button
    And Verify that user shouldn't be able to add an event without filling the "<compulsory>" fields
    And User clicks Save button
    Then Verify that "This value should not be blank." message is displayed

    Examples:
      | compulsory             |
      | title                  |
      | organizer-display-name |
      | organizer-email        |
