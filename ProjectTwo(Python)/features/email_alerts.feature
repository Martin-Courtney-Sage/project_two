Feature: Email Alerts

  Scenario: Overdraft
    Given The User has an account
    When There is funds that are withdrawn past the alloted amount in the account
    Then The User will recieve a notification through email notifing them of the overdraft