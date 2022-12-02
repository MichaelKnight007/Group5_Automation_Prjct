@trad906
Feature:Add Event 2 ( with cucumber - Yasar)

  User Story:
  As a Store Manager and Sales Manager, I should be able to add an event

  Background: For the scenarios in the feature file, user is expected to be on the 'Vehicles' page.
    Given User is on the login page
    When User logs in as a "Driver"
    And User goes to "Fleet" module and "Vehicles" sub-module

  @yasarAC1
  Scenario:User can access the "Add Event" page from the "General Information" page
  (by clicking on any vehicle/row under Fleet-Vehicle module)
    When User clicks any Vehicle Row under All Cars menu
    Then Verify that the user is on General Information page

  @yasarAC2
  Scenario:User clicks on "Add event" button, and "Add Event" page pops up
    When User clicks any Vehicle Row under All Cars menu
    And User clicks on Add Event button
    Then Verify that the user is on the Add Event page

  @yasarAC3
  Scenario:User can mark the event with any color
    When User clicks any Vehicle Row under All Cars menu
    And User clicks on Add Event button
    When User clicks blue radioButton
    And User clicks green radioButton
    And User clicks yellow radioButton
    And User clicks red radioButton

  @yasarAC4
  Scenario:User can mark the event as "All-day event" and time (hours) field disappears
    When User clicks any Vehicle Row under All Cars menu
    And User clicks on Add Event button
    When User clicks All-day event checkbox
    Then Verify that time field disappears

  @yasarAC5
  Scenario:User can repeat the event by clicking "Repeat" checkbox and options are:
  "Daily"
  "Weekly"
  "Monthly"
  "Yearly"
    When User clicks any Vehicle Row under All Cars menu
    And User clicks on Add Event button
    When User clicks Repeat checkbox
    And User clicks Repeats dropbox
    Then Verify that user sees Daily options

  @yasarAC6
  Scenario:User can end the event by:
  "Never"
  "After" (by entering occurrence)
  "By" (by selecting date and time)
    When User clicks any Vehicle Row under All Cars menu
    And User clicks on Add Event button
    And User clicks Repeat checkbox
    When User clicks Never radioButton
    And User clicks After radioButton
    And User clicks By radioButton
    Then Verify that the user sees Summary part

  @yasarAC7
  Scenario:User can see the event in the General information page
    When User clicks any Vehicle Row under All Cars menu
    And User clicks on Add Event button
    When User enters required data in the Add Event Title
    And User clicks Save button
    And User clicks accordion toggle and events are seen