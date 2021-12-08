Feature: Booking accommodation
  As a user I want to be able to book an accommodation unit for the desired number of people and rooms

  Scenario: Reserve hotel
    Given I am on booking home page
    When I change language "Srpski"
    And I enter destination "Lisabon"
    #Date format DD month YYYY
    #april ima 2 space izmedju meseca i godine, vodi racuna kako je napisano na UI; 22 feb - 3 mart; vezba "2 januar 2022" "13 januar 2022" | "22 februar 2022" "3 mart 2022"
    And I select dateFrom and dateTo "2 januar 2022" "13 januar 2022"
    And I choose number of person, children and rooms "6" "1" "4" "3"
    And I click button Search
    Then I should see desired choice
    And I check the budget filters
    And I check the distance filters
    And I select best reviewed and lowest price
    And I click the first best choice
    And I save booking
    And I reserve the hotel
    And I select the apartment
    And I click reserve
    And I fill the form about personal information
    And I check the last step




