Feature: New Customer details

  Scenario: Create a new customer and Account
    Given a new customer
    Then the response status should be 201
    And a new customerNumber mapped to Account Number
    Then the response status should be 201


  Scenario: Create a new customer and Update customer details
    Given a new customer
    Then the response status should be 201
    And I update the customer
    Then the response status should be 200

  Scenario: Create a new customer and get customer details
    Given a new customer
    Then the response status should be 201
    And Get the customer
    Then the response status should be 200

  Scenario: Get all customer Details
    Given Get All Customer Details
    Then the response status should be 200

  Scenario: Create a new customer and delete customer details
    Given a new customer
    Then the response status should be 201
    And Delete Customer Details
    Then the response status should be 200

  Scenario: Create a new customer, Account and Get Account Details
    Given a new customer
    Then the response status should be 201
    And a new customerNumber mapped to Account Number
    Then the response status should be 201
    Given Get Account Number detail
    Then the response status should be 200

  Scenario: NonExist Account number details
    Given Get Non Account Number detail
    Then the response status should be 404

