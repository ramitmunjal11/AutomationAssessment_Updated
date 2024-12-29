Feature: User Sign Up

  Scenario: Successful User Registration
    Given I am on the sign-up page
    When I enter valid details "FName" "LName" email "Password123" "Password123"
    And I click on Create an Account
    Then I should see a success message

  Scenario: Login with username password
  	Given I am on login page
  	When I enter email and "Password123" and click submit
  	Then I should able to login