@TRAD-1038
Feature: As a user, I should be able to use Driver filter under Fleet-Vehicle page

  Background:
    Given User is on the login page
    And User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And User clicks Filter Button
    And User select Driver option under ManageFilter dropdown
    And User clicks Driver All button
    And User clicks Contains dropdown

  @TRAD-1039
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

  @TRAD-1050
  Scenario Outline:- When user selects "Contains" method with a keyword,
  the results should contain the specified keyword
    When User selects contains method
    And User enters "<keyword>"
    And User clicks update button
    Then Results should contain "<keyword>"
    Examples:
      | keyword  |
      | Zack     |
      | Blaine   |
      | Franklyn |

  @TRAD-1051
  Scenario Outline:  When user selects "Does Not Contain" method with a keyword,
  the results should not contain the specified keyword
    When User selects does not contain method
    And User enters "<keyword>"
    And User clicks update button
    Then Results should not contain "<keyword>"
    Examples:
      | keyword  |
      | Zack     |
      | Blaine   |
      | Franklyn |

  @TRAD-1052
  Scenario Outline:  When user selects "Starts-with" method with a keyword,
  the results should start with the specified keyword
    When User selects Starts with method
    And User enters "<keyword>"
    And User clicks update button
    Then Results should start with specified "<keyword>"
    Examples:
      | keyword |
      | Mrs     |
      | Ms      |
      | Jacki   |

  @TRAD-1053
  Scenario Outline:   When user selects "Ends With" method with a keyword,
  the results should end with the specified keyword
    When User selectsEnds with method
    And User enters "<keyword>"
    And User clicks update button
    Then Results should end with specified "<keyword>"
    Examples:
      | keyword |
      | Price   |
      | an      |
      | ohns    |

  @TRAD-1054
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

  @TRAD-1055
  Scenario Outline: Methods ("Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to")
  shouldn't accept non-alphabetical characters
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
      | Ends With        | 8       | #       |
      | Is Equal to      | 5       | =       |
