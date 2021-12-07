Feature: Test

  Scenario: Test
    Given I am on booking home page
    When I change language "Srpski"
    And I enter destination "Lisabon"
    #Date format DD month YYYY
    #april ima 2 space izmedju meseca i godine, vodi racuna kako je napisano na UI; 22 feb - 3 mart
    And I select dateFrom and dateTo "22 februar 2022" "3 mart 2022"
    And I choose number of person, children and rooms "6" "1" "4" "3"
    And I click button Search



