#TRAD-986 - Test Execution ID

@wip
Feature: TRAD-901

  US: Last Odometer Filter (Aybars)

  Background:
    Given user is on the login page
    And user logged in as "sales manager"
    And user is on the D- "Dashboard" page
    And user select vehicles under the fleet menu
    And user is on the "All Cars" page
    And user click on the filter button
    And user click on the Manage Filters button
    And user enter "last odometer" in the input
    And user click last odometer checkbox
    And user click on the last odometer dropbox
    And user click the dropdown


  #AC-1:

  Scenario: "Last Odometer" filter has the methods below
    Then filter should have methods below
      | Between             |
      | Not Between         |
      | Equals              |
      | Not Equals          |
      | More Than           |
      | Less Than           |
      | Equals Or More Than |
      | Equals Or Less Than |
      | Is Empty            |
      | Is Not Empty        |


    #AC-2:

  Scenario: if user selects "Between" method with numeric values, the results should be between the specified values
    And user select between method
    And user enter numeric values "1000" and "10000"
    And user click the update button
    Then results should be between the specified values


    #AC-3:

  Scenario: if user selects "Equals" method with numeric values, the results should match the specified value exactly
    And user select equals method
    And user enter numeric value "1000"
    And user click the update button
    Then results should match specified value


    #AC-4:

  Scenario: if user selects "More than" method with numeric values, the results should be more than the specified value
    And user select more than method
    And user enter numeric value "1000"
    And user click the update button
    Then results should be more than the specified value


    #AC-5:

  Scenario: if user selects "Less than" method with numeric values, the results should be be less than the specified value
    And user select less than method
    And user enter numeric value "1000"
    And user click the update button
    Then results should be less than the specified value


    #AC-6:

  Scenario: if user selects "Is Empty" method, only empty values should be displayed
    And user select is empty method
    And user click the update button
    Then only empty values should be displayed


    #AC-7:

  Scenario Outline:  Methods below should NOT accept non-numeric values
    When user select "<method>" method
    And user enter "asd>£$½" into input
    And user enter "12%zxc" into second input
    Then method should not accept non-numeric values

    Examples:
      | method    |
      | Between   |
      | Equals    |
      | More Than |
      | Less Than |
