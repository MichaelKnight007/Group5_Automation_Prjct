Feature:Vehicle Table Arrangements

  User Story:
  As a user, I should be able to arrange vehicle table display, under Fleet-Vehicle page


  Background:For the scenarios in the feature file, user is expected to be on the 'Vehicles' page
    Given user is on the vehicles page for arrangement
  @wip
  Scenario:As a user, I should be able to arrange vehicle table display, under Fleet-Vehicle page
    When user clicks View Per Page button
    And  user sees 10-25-50-100 numbers
    And  user clicks any of them
    Then  user should see same number of vehicle on the page with the chosen one
