
Feature: Account transfers
  Background:
    Given Two new customer and it respective account
    And the response status should be 201
    Then Check account balance 'FROMACCOUNT'
    And Check account balance 'TOACCOUNT'

  @positive
  Scenario: Successful transfer within available balance
    When User transfer 5 from the created account
    Then the response status should be 200
    And Check account balance 'FROMACCOUNT'
    And Check account balance 'TOACCOUNT'
    Then Get all transaction for respective account number

  @negative
  Scenario: Reject transfer exceeding available balance
    When I attempt to transfer more than the current balance
    Then the response status should be 400
    Then Get all transaction for respective account number

  @negative
  Scenario: Invalid amount transfer
    When User transfer -15 from the created account
    Then the response status should be 400

  Scenario: Get all Transaction
  Then Get all transaction for respective account number