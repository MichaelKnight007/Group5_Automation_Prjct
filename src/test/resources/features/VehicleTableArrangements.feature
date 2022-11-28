
Feature:Vehicle Table Arrangements

  User Story:
  As a user, I should be able to arrange vehicle table display, under Fleet-Vehicle page


  Background:For the scenarios in the feature file, user is expected to be on the 'Vehicles' page
    Given User is on the login page
    When User logs in as a "Store Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    Then Verify that the user is on "All Cars" module


  Scenario Template:As a user, I should be able to arrange vehicle table display, under Fleet-Vehicle page
    When user clicks View Per Page button
    And  user clicks "<expectedNumber>" which are shown
    Then Verify that <actualNumber> on the page is same with the number user clicks
    Examples:
      | expectedNumber | actualNumber |
      | 10             | 10           |
      | 25             | 25           |
      | 50             | 50           |
      | 100            | 100          |


  Scenario:The value of 'View Per Page' should be '25' by default
    Then User should see 25 on the View Per Page dropdown button by default


  Scenario:'View Per Page' defines the number of total rows in a page and it has the options numbers of 10,25,50,100
    When  user clicks View Per Page button
    Then  Verify that View Per Page dropdown includes below options
      | 10  |
      | 25  |
      | 50  |
      | 100 |


  Scenario Outline:User can remove all sorts and filters on the page by using the reset button
    When user filters the page by clicking "<Filter>"
    And  user clicks refresh button
    Then Verify that sorts and filters are removed
    Examples:
      | Filter |
      | 10     |
      | 25     |
      | 50     |
      | 100    |

  @wipv
  Scenario Outline:User can sort a column in ascending or descending order by clicking the column name
    When user clicks any   "<columName>"
    Then Verify that user sees columnName as sorted in ascending or descending order
    Examples:
      | columName            |
      | License Plate        |
      | Tags                 |
      | Driver               |
      | Location             |
      | Chassis Number       |
      | Last Odometer        |
      | Immatriculation Date |
      | First Contract Date  |
      | CVVI                 |
      | Seats Number         |
      | Doors Number         |
      | Color                |
      | Fuel Type            |
      | CO2 Emissions        |
      | Horsepower           |
      | Horsepower Taxation  |
      | Power (kW)           |











































