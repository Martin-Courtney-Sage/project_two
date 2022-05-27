Feature: Login system works

  Scenario: Valid Login Credential for User Role
    Given The User is on Login Page
    When The User provides correct user details for general user role and clicks Login button
    Then The User is sent to User Profile Page

  Scenario: Valid Login Credential for Admin Role
    Given The User is on Login Page
    When The User provides correct user details for admin user role and clicks Login button
    Then The User is sent to Admin Profile Page

  Scenario: Invalid Login Credential
    Given The User is on Login Page
    When The User provides incorrect user details
    Then The User is provided with alert.
