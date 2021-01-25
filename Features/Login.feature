Feature: Login  

  Scenario Outline: Check login functionality with multiple users
    Given Open Page "http://automationpractice.com/"
    And Login with username "<Username>" and password "<Password>"
    When Product is selected
    Then new contact icon is present on the page
    Then Product successfully checked out

    Examples:
      | Username                | Password         |
      | abc76d8092@gmail.com    | Pas7653gh        |
      | Data2357@gmail.com      | Q87fsf345        |
      | Dafdh545vf45657@gmail.com   | R908575g37k45 |


  Scenario: user should sign up to the application
    Given Open Page "http://automationpractice.com/"
    When User enter valid data on the page
      | Fields                 | Values              |
      | First Name             | Nitesh              |
      | Last Name              | Kumar               |
      | Password               | R985756567k45       |
      | Address                | ranchi              |
      | City                   | Ranchi              |
      | Zip Code               | 88396               |
      | Phone                  | 7847934834          |
    Then User registration should be successful.