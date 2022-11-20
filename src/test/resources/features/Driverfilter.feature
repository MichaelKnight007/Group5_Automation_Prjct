Feature: As a user, I should be able to use Driver filter under Fleet-Vehicle page

  Background:
    Given User logs in as a Salesmanager
    And User should go to dashboard page
    And User hover over fleet menu
    And User clicks vehicles page under fleet menu
    And User clicks Filter Button
    And User select Driver option under ManageFilter dropdown
    And User clicks Driver All button
    And User clicks Contains dropdown

  @wip
  Scenario: "Driver" filter has the methods below:
  Contains
  Does Not Contain
  Is Equal To
  Starts With
  Ends With
  Is Any Of
  Is Not Any Of
  Is Empty
  Is Not Empty
  //tbody[@class='grid-body']//td[4]
    When User clicks Contains dropdown
    Then User should see all options under Driver Filter Menu

  Scenario Outline:- When user selects "Contains" method with a keyword,
  the results should contain the specified keyword
    When User selects contains method
    And User enters "<keyword>"
    And User clicks update button
    Then Results should contain keywords
    Examples:
      | keyword |
      | Tresa   |
      | Lemke   |
      | Joseph  |

  Scenario Outline:  When user selects "Does Not Contain" method with a keyword,
  the results should not contain the specified keyword
    When User selects does not contain method
    And User enters "<keyword>"
    And User clicks update button
    Then Results should not contain keywords
    Examples:
      | keyword |
      |         |
      |         |
      |         |

