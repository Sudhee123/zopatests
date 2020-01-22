Feature: As an end user
         I would like to fill the personal details form,
         so that I can get the personalised loan rates

  Scenario Outline: Filling the form with the valid emailId and valid input data for all the remaining fields to validate the emailId field
    Given User is on Zopa Loans Homepage
  When I navigate to get my personal rates page
  And  I have filled the form with the valid details to apply the loan for "<type>"
  Then I have validated the fields on the form
  #And  I have saved the test data on to a file
   Examples:
   |type|
   |CAR|
   |HOME_IMPROVEMENTS|
   |CONSOLIDATE|
   |OTHER|

    #Postcode field validation
  Scenario Outline: Filling the form with the valid postcode and valid input data for all the remaining fields to validate the postcode field
    Given User is on Zopa Loans Homepage
    When I navigate to get my personal rates page
    And I have filled the form with the valid details to apply the loan for "<type>"
    Then I have validated the postcode field on the form
    #And  I have saved the test data on to a file
   Examples:
     |type|
     |CAR|
     |HOME_IMPROVEMENTS|
     |CONSOLIDATE|
     |OTHER|

  Scenario Outline: Filling the form with the valid postcode and valid input data for all the remaining fields to validate the phone number field
   Given User is on Zopa Loans Homepage
    When I navigate to get my personal rates page
    And I have filled the form with the valid details to apply the loan for "<type>"
    Then I have validated the phone number field on the form
    #And  I have saved the test data on to a file
   Examples:
     |type|
     |CAR|
     |HOME_IMPROVEMENTS|
     |CONSOLIDATE|
     |OTHER|


