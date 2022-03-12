Feature: login to swag lab and verifying navigation menu
  @LoginWith_standard_user
  Scenario: user login with standard_user
    Given I visit the website
    When I enter user name as standard_user and password
    And click login button
    Then user should login to main page
    And I select All items
    Then I should see all items on main pages
    When I select Reset app from menu
    Then I should to see reset of swag lab
    When I select about from menu
    Then I should take to about page of swag lab
    When I select Logout from menu and got to login page


  @LoginWith_locked_out_user
  Scenario: user login with locked_out_user
    Given I visit the website
    When I enter user name  as locked_out_user and password
    And click login button
    Then user shouldn't login to main page
    And browser should close


@LoginWith_problem_user
  Scenario: user login with problem_user
    Given I visit the website
    When I enter user name as problem_user and password
    And click login button
    Then user should login to main page
    And I select All items
    Then I should see all items on main pages
    When I select Reset app from menu
    Then I should to see reset of swag lab
    When I select Logout from menu with problem_user and got to login page
    When I select about from menu with problem_user
  And browser should close


@LoginWith_performance_glitch_user
  Scenario: user login with performance_glitch_user
    Given I visit the website
    When I enter user name as performance_glitch_user and password
    And click login button
    Then user should login to main page
    And I select All items
    Then I should see all items on main pages
    When I select Reset app from menu
    Then I should to see reset of swag lab
    When I select about from menu
    Then I should take to about page of swag lab
    When I select Logout from menu with performace_glitch_user and got to login page