@TRAD-902
Feature: As a Store Manager and Sales Manager, I should be able to add an event

  Background: User is on "Add Event" page
    When User is on the login page

  @TRAD-1082
  Scenario Outline: User should be able to add an event
    #AC : 1-3-4
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


  @TRAD-1083
  Scenario: Driver should NOT be able to add an event
    #AC : 2
    And User logs in as a "Driver"
    And User goes to "Fleet" module and "Vehicles" sub-module
    When User clicks any Vehicle Row under All Cars menu
    Then Verify that Driver can NOT see Add Event button


  @TRAD-1084
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
