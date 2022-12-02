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

    When User clicks Contains dropdown
    Then User should see all options under Driver Filter Menu

  Scenario Outline:- When user selects "Contains" method with a keyword,
  the results should contain the specified keyword
    When User selects contains method
    And User enters "<keyword>"
    And User clicks update button
    Then Results should contain "<keyword>"
    Examples:
      | keyword |
      | Tresa   |
      | Lemke   |
      | Joseph  |
  @wip1
  Scenario Outline:  When user selects "Does Not Contain" method with a keyword,
  the results should not contain the specified keyword
    When User selects does not contain method
    And User enters "<keyword>"
    And User clicks update button
    Then Results should not contain "<keyword>"
    Examples:
      | keyword |
      | Lemke   |
      | Nona    |
      | Mrs     |

  Scenario Outline:  When user selects "Starts-with" method with a keyword,
  the results should start with the specified keyword
    When User selects Starts with method
    And User enters "<keyword>"
    And User clicks update button
    Then Results should start with specified "<keyword>"
    Examples:
      | keyword |
      | mrs     |
      | ms      |
      | Ahmad   |

  Scenario Outline:   When user selects "Ends With" method with a keyword,
  the results should end with the specified keyword
    When User selectsEnds with method
    And User enters "<keyword>"
    And User clicks update button
    Then Results should end with specified "<keyword>"
    Examples:
      | keyword |
      | en      |
      | an      |
      | hilll   |

  Scenario Outline:When user selects "Is Equal to" method with a keyword,
  the results should match the specified keyword exactly
    When User selects Is Equal to method
    And User enters "<keyword>"
    And User clicks update button
    Then Results should match specified "<keyword>"
    Examples:
      | keyword         |
      | Tobie Ziemann   |
      | Bettye Wisozk   |
      | Hollis Thompson |

    When User selects "<Methodname>"
    And User enters "<Numbers>"
    And User enters "<Symbols>"
    And User clicks update button
    Then Message should be "No entities were found to match your search. Try modifying your search criteria..."
    Examples:
      | Methodname       | Numbers | Symbols |
      | Contains         | 1       | .       |
      | Does Not Contain | 2       | ,       |
      | Starts With      | 3       | _       |
      | Ends With        | 4       | _       |
      | Is Equal to      | 5       | =       |
