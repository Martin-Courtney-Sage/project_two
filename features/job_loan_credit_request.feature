Feature: User can apply for a job at the bank, make loan requests, and make credit card request.

  Scenario: User applys for a job at the bank
    GIVEN The User is on the profile page
    WHEN The User fills out a job application form and clicks on the submit button
    THEN The User would have applied to a job and can view status of the job application below the form.
  
  Scenario: User makes a loan request
    GIVEN The User is on the profile page
    WHEN The User fills out a loan request form and clicks on the submit button
    THEN The User would have made loan request and can view status of the loan application below the form.
    
  Scenario: User makes a credit card request
    GIVEN The User is on the profile page
    WHEN The User fills out a credit card request form and clicks on the submit button
    THEN The User would have made credit card request and can view status of the credit card application below the form.
