Feature: User can view and update account and appointment information

  Scenario: User views bank statement
    Given The User is on the Profile Page
    When The User clicks on the accounts button
    Then The User can view all activity and balances in their Bank Statement

  Scenario: User updates email on account information
    Given The User is on the Profile Page
    When The User clicks on the update information link and enters a new email in the fields then clicks submit
    Then The User will see a confirmation that the change has been made

 Scenario: User can create and schedule an appointment
    Given The User is on the Profile Page
    When The User clicks the link to appointments and chooses an available time and date
    Then The User gets a confirmation that the appointment has been created

 Scenario: User views upcoming appointments
    Given The User is on the Profile Page
    When The User clicks the link to appointments
    Then The User can see when and where the appointment is taking place

 Scenario: User cancels an arranged appointment
    Given The User is on the Profile Page
    When The User clicks on the link to appointments and views upcoming meetings,they click the cancel button
    Then The User receives a confirmation and the appointment is deleted from their page