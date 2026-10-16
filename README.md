Create a production-ready Maven-based REST API test automation framework using Java 11 or higher, 
JUnit 5, Cucumber BDD, and REST Assured.
The framework must automate customer, account, transaction, and transfer APIs. Implement reusable API clients,
request and response models, configuration management, scenario context for sharing generated identifiers, 
Cucumber hooks, tagged feature files, assertions, request and response logging, and HTML,JSON/Cucumber reporting.
Cover POST operations for creating a customer with an account and adding an account to an existing customer. 
Cover GET operations for account and transaction details. Cover PUT for updating customer details, DELETE for deleting
a customer by customerNumber, and put for fund transfers.
Automate an end-to-end customer lifecycle scenario, a successful transfer scenario where the amount is within the available balance,
and a rejected transfer scenario where the amount exceeds the account balance.
Externalize the base URL configuration. Avoid hard-coded generated identifiers. Use POJOs and reusable REST Assured 
specifications. Support execution through Cucumber tags and generate HTML and JSON reports. Include documentation explaining the project structure, execution commands, assumed endpoints, expected response fields, and changes required to align the suite with the actual OpenAPI contract.

Observation :
The Get Customer request is not retrieving all account details mapped to the customer.