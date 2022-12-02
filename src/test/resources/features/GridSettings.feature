#User Story :
#As a user, I should be able to arrange vehicle table columns via "grid settings" under Fleet-Vehicles page
#Acceptance Criteria:
#1- "Grid Settings" should be visible when user clicks on the gear icon
#2-  Column names in grid settings should be shown as below:
#Id
#License Plate
#Tags
#Driver
#Location
#Chassis Number
#Model Year
#Last Odometer
#Immatriculation Date
#First Contract Date
#Catalog Value (VAT Incl.)
#Seats Number
#Doors Number
#Color
#Transmission
#Fuel Type
#CO2 Emissions
#Horsepower
#Horsepower Taxation
#Power (KW)
#3- User can find any column by typing the column name on "Quick Search" input box
#4- User can select any column by clicking the column name
#5- User can arrange the order of the columns (by dragging and dropping)
#6- User can see all corresponding changes under 'Fleet-Vehicles' pages
@grid-settings
Feature: Grid Settings

  Background:
    Given User is on the login page
    And User logs in as a "Sales Manager"
    And User goes to "Fleet" module and "Vehicles" sub-module
    And The user clicks on Grid Settings button from the top right menu
  Scenario: AC1- Grid Settings is visible
    Then Grid Settings menu shows up

  Scenario: AC2- Grid Settings list options
    Then Grid Settings list options are as listed below
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |

  Scenario: AC3- "Quick Search"
    When The user types following column names into quick search field
      | Driver        |
      | Tags          |
      | License Plate |
      | Model Year    |
      | Last Odometer |
      | Seats Number  |
      | Color         |
    Then The relevant column shows up in the grid settings


  Scenario: AC3- "Quick Search" Partial Search
    When The user types following column names into quick search field
      | Dri      |
      | Tag      |
      | License  |
      | Model    |
      | Last Odo |
      | Seats    |
      | Col      |
      | Ho       |
      | Fu       |
      | Ca       |
      | A        |
      | B        |
    Then The relevant column shows up in the grid settings


  Scenario: AC4- Click on the column name
    When The user clicks on the following columns from grid settings
      | Driver        |
      | Tags          |
      | License Plate |
      | Model Year    |
      | Last Odometer |
      | Seats Number  |
      | Color         |
    Then The relevant column shows up in the fleet - vehicles table



  Scenario: AC5- Drag and drop columns
    When The user can drag "Driver" column and drop to the index 1
    Then "Driver" column is positioned at index 1

    When The user can drag "Location" column and drop to the index 2
    Then "Location" column is positioned at index 2

    When The user can drag "Model Year" column and drop to the index 3
    Then "Model Year" column is positioned at index 3



  Scenario: AC6- User can see all corresponding changes
    When The user clicks on the following columns from grid settings
      | Driver        |
      | Tags          |
      | License Plate |
      | Model Year    |
      | Last Odometer |
      | Seats Number  |
      | Color         |
      | Id            |

    And The user can drag "Id" column and drop to the index 1
    And The user can drag "License Plate" column and drop to the index 2
    And The user can drag "Driver" column and drop to the index 3
    And The user can drag "Color" column and drop to the index 4


