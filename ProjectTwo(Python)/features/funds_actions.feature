Feature: User can withdraw/deposit/transfer funds between accounts

  Scenario: User withdraws funds
    Given The User is on the Profile Page
    When The User selects an account and the amount they wish to withdraw, then clicks the Withdraw button
    Then The account will update and return the new information to the User reflecting the changes

  Scenario: User deposits funds
    Given The User is on the Profile Page
    When The User selects an account and the amount they wish to deposit, then clicks the Deposit button
    Then The account will update and return the new information to the User reflecting the changes

  Scenario: User transfers funds
    Given The User is on the Profile Page
    When The User selects the accounts they wish to transfer money between and the desired amount, then clicks the Transfer button
    Then Then the accounts will update and return the new information to the User reflecting the changes
