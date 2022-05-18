Feature: Manager can view and approve applications for job, loan and credit card.

  Scenario: Manager views applications for job
    Given The Manager is on the profile page
    When The Manager clicks on the view job applications button
    Then The job applications fill the table below the button.

  Scenario: Manager views applications for loan
    Given The Manager is on the profile page
    When The Manager clicks on the view loan applications button
    Then The loan applications fill the table below the button.

  Scenario: Manager views applications for credit card
    Given The Manager is on the profile page
    When The Manager clicks on the view credit card applications button
    Then The credit card applications fill the table below the button.

  Scenario: Manager approves applications for job
    Given The Manager is on the profile page and job applications fill the table below the button
    When The Manager clicks on the approve button for a job application
    Then The job applications will be approved and viewable as such by the User.

  Scenario: Manager rejects applications for job
    Given The Manager is on the profile page and job applications fill the table below the button
    When The Manager clicks on the reject button for a job application
    Then The job applications will be rejected and viewable as such by the User.

  Scenario: Manager approves applications for loan
    Given The Manager is on the profile page and loan applications fill the table below the button
    When The Manager clicks on the approve button for a loan application
    Then The loan applications will be approved and viewable as such by the User.

  Scenario: Manager rejects applications for loan
    Given The Manager is on the profile page and loan applications fill the table below the button
    When The Manager clicks on the reject button for a loan application
    Then The loan applications will be rejected and viewable as such by the User.

  Scenario: Manager approves applications for credit card
    Given The Manager is on the profile page and loan applications fill the table below the button
    When The Manager clicks on the approve button for a credit card application
    Then The credit card applications will be approved and viewable as such by the User.

  Scenario: Manager rejects applications for credit card
    Given The Manager is on the profile page and credit card applications fill the table below the button
    When The Manager clicks on the reject button for a credit card application
    Then The credit card applications will be rejected and viewable as such by the User.