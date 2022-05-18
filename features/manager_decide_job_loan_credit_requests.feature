Feature: Manager can view and approve applications for job, loan and credit card.

  Scenario: Manager views applications for job
    GIVEN The Manager is on the profile page
    WHEN The Manager clicks on the view job applications button
    THEN The job applications fill the table below the button.
  
  Scenario: Manager views applications for loan
    GIVEN The Manager is on the profile page
    WHEN The Manager clicks on the view loan applications button
    THEN The loan applications fill the table below the button.
    
  Scenario: Manager views applications for credit card
    GIVEN The Manager is on the profile page
    WHEN The Manager clicks on the view credit card applications button
    THEN The credit card applications fill the table below the button.
    
  Scenario: Manager approves applications for job
    GIVEN The Manager is on the profile page and job applications fill the table below the button
    WHEN The Manager clicks on the approve button for a job application
    THEN The job applications will be approved and viewable as such by the User.
    
  Scenario: Manager rejects applications for job
    GIVEN The Manager is on the profile page and job applications fill the table below the button
    WHEN The Manager clicks on the reject button for a job application
    THEN The job applications will be rejected and viewable as such by the User.
    
  Scenario: Manager approves applications for loan
    GIVEN The Manager is on the profile page and loan applications fill the table below the button
    WHEN The Manager clicks on the approve button for a loan application
    THEN The loan applications will be approved and viewable as such by the User.
    
  Scenario: Manager rejects applications for loan
    GIVEN The Manager is on the profile page and loan applications fill the table below the button
    WHEN The Manager clicks on the reject button for a loan application
    THEN The loan applications will be rejected and viewable as such by the User.
    
  Scenario: Manager approves applications for credit card
    GIVEN The Manager is on the profile page and loan applications fill the table below the button
    WHEN The Manager clicks on the approve button for a credit card application
    THEN The credit card applications will be approved and viewable as such by the User.
    
  Scenario: Manager rejects applications for credit card
    GIVEN The Manager is on the profile page and credit card applications fill the table below the button
    WHEN The Manager clicks on the reject button for a credit card application
    THEN The credit card applications will be rejected and viewable as such by the User.
