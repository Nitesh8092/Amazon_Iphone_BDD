Feature: Amazon 

  Scenario: Search Iphone in amazon and print result list with prize
    Given Open Page "https://www.amazon.in/"
    When Search for Iphone product in search bar
    Then Return search result along with price


