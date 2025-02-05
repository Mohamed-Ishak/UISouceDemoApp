Feature: Login Functionality
  Scenario Outline: Login with invalid credentials
  Given I open login page
  When I enter a username "<username>"
  And I enter a password "<password>"
  And I click login
  Then I should see an error message

    Examples:
    |username| password   |
    |user1   | wrongpass1 |
    |user2   | wrongpass2 |
    |user3   | wrongpass3 |
    |user4   | wrongpass4 |

