Feature: Common Features

  #Login
  Background: User on the login page
    Given User is on the login page

  Scenario Outline: Login as a <userType>
    When User logs in as a "<userType>"
    Then Verify that the user is on "<pageSubTitle>" page

    Examples:
      | userType      | pageSubTitle    |
      | Driver        | Quick Launchpad |
      | Sales Manager | Dashboard       |
      | Store Manager | Dashboard       |


#  Also you can use without examples like :
#  Scenario: Login as a "Sales Manager"
#    When User logs in as a "Sales Manager"
#    Then Verify that the user is on "Dashboard" page


  # goToModule
  Scenario Outline:  Go to "Vehicles" module
    When User logs in as a "<userType>"
    And User goes to "Fleet" module and "Vehicles" sub-module
    Then Verify that the user is on "<Cars>" module

    Examples:
      | userType      | Cars     |
      | Driver        | Cars     |
      | Sales Manager | All Cars |
      | Store Manager | All Cars |


#  Also you can use without examples like :
#  Scenario: Go to "Vehicles" module
#    When User logs in as a "Driver"
#    And User goes to "Fleet" module and "Vehicles" sub-module
#    Then Verify that the user is on "Cars" module


    # Select Car
  Scenario: Select a car
    When User logs in as a "Driver"
    And User goes to "Fleet" module and "Vehicles" sub-module
    # toDo : And User selects a car
    # ToDo : Then Verify that the user select car