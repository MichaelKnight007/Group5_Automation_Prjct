Feature:Vehicle Table Arrangements

  User Story:
  As a user, I should be able to arrange vehicle table display, under Fleet-Vehicle page


  Background:For the scenarios in the feature file, user is expected to be on the 'Vehicles' page
    Given User is on the login page
    When "Store Manager" logs in
    And User goes to "Fleet" module and "Vehicles" sub-module
    Then Verify that the user is on "All Cars" module

  @wipv

  Scenario Template:As a user, I should be able to arrange vehicle table display, under Fleet-Vehicle page
    When user clicks View Per Page button
    And  user clicks <"expectedNumber"> which are shown

    Examples:
      | "expectedNumber" |

      | 10               |
      | 25               |
      | 50               |
      | 100              |



