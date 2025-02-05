#@allure.label.owner=Mohamed-Ishaq
Feature: Login E2E Scenario

  Scenario Outline:
    Given I open login page
    When I enter a username "<username>"
    And I enter a password "<password>"
    And I click login
    And Verify that user is navigated to the product page successfully
    When Add two most expensive products to the cart
    When I click on the Cart button
    And Verify that user is navigated to Cart page successfully
    And Verify that previous products are selected
    When I click on the Checkout button
    And Verify that user is navigated to Checkout page successfully
    When I Fill the displayed Form
    And I click on Continue button
    Then Verify that user is navigated to Overview page successfully
    Then Verify the items total amount before taxes
    Then Verify that the URL matches with the expected link
    Then I click on Finish button
    Then Verify Thank you and Order has been dispatched messages
    Examples:
      |username        | password     |
      |standard_user   | secret_sauce |