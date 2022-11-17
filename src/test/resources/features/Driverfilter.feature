
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

  Scenario Outline: Method actions should provide expected conditions.
    When User selects "<Method>"
    And User enters "<Keyword>"in search box
    And User clicks update button
    Then The results should be "<Expected Condition>"
    Examples:
      | Method           | Keyword      | Expected Condition               |
      | Contains         | Tresa        | Results Contain "Tresa"           |
      | Does Not Contain | Nick         | Results Does Not Contain "Nick"   |
      | Starts With      | Phung        | Results start with "Phung"        |
      | Ends With        | Lemke        | Results end with "Lemke"          |
      | Is Equal To      | Chi Hartmann | Results match with "Chi Hartmann" |

  Scenario Outline: Methods  ("Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to")
  shouldn't accept non-alphabetical characters
    When User selects "<Method>"
    And User enters "<Non Alphabetical Characters>"in search box
    And User clicks update button
    Then The results should match "No entities were found to match your search. Try modifying your search crite..."
    Examples:
      | Method           | Non Alphabetical Characters |
      | Contains         | .                           |
      | Does Not Contain | .                           |
      | Starts With      | _                           |
      | Ends With        | _                           |
      | Is Equal To      | =                           |





