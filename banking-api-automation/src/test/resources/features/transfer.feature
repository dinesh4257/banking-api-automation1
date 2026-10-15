
Feature: Account transfers
  Background:
    Given Two new customer and it respective account
    And the response status should be 201


  @positive
  Scenario: Successful transfer within available balance
    When User transfer 5 from the created account
    Then the response status should be 200
    Then Get all transaction for respective account number

  @negative
  Scenario: Reject transfer exceeding available balance
    When I attempt to transfer more than the current balance
    Then the response status should be 400
    Then Get all transaction for respective account number

  Scenario: Get all Transaction
  Then Get all transaction for respective account number