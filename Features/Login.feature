Feature: Login  

  Scenario: Check login functionality with multiple users
    Given Open Page "https://www.amazon.in/"
    When Search for Iphone product in search bar
    Then Return search result along with price


