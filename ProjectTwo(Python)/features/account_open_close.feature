Feature: User can open and close accounts

  Scenario: User opens account
    Given The User is on the Profile Page
    When The User fills out the fields and clicks on the Create Account button
    Then The User shall have a new account created and returned in the table below

  Scenario: User closes account
    Given The User is on the Profile Page
    When The User clicks the Delete Account button
    Then The webpage will notify the User that the account has been deleted
