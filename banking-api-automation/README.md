# Banking API Automation Suite

Maven-based API test automation using Java 11+, REST Assured, JUnit 5, and Cucumber.

## Covered flows
- Create customer with an account
- Add an account to an existing customer
- Retrieve account details
- Retrieve transaction details
- Update customer details
- Delete by customer number
- Successful transfer
- Rejected transfer when amount exceeds the current balance

## Assumed API contract
The requirement did not include an OpenAPI specification, so the suite uses these configurable contract assumptions:

- `POST /customers`
- `POST /customers/{customerNumber}/accounts`
- `GET /accounts/{accountNumber}`
- `GET /accounts/{accountNumber}/transactions`
- `PUT /customers/{customerNumber}`
- `DELETE /customers/{customerNumber}`
- `POST /transfers`

Expected create response fields:
- `customerNumber`
- `account.accountNumber`

Expected transfer response fields:
- `status`
- `error.code` for rejected transfers

Update the paths and JSON mappings in `BankingApiClient.java` and `BankingSteps.java` to match the real API contract.

## Run
```bash
mvn clean test -Dbase.url=https://api.example.com -Dapi.token=YOUR_TOKEN
```

Run specific tags:
```bash
mvn clean test -Dcucumber.filter.tags="@positive"
mvn clean test -Dcucumber.filter.tags="@negative"
mvn clean test -Dcucumber.filter.tags="@customer"
```

Reports:
- `target/cucumber-report.html`
- `target/cucumber-report.json`

## Environment precedence
1. JVM system property, for example `-Dbase.url=...`
2. Environment variable, for example `BASE_URL`
3. `src/test/resources/config/application.properties`

## Recommended next additions
- JSON schema validation
- OAuth token provider
- Retry only for safe GET requests
- Contract tests from OpenAPI
- CI pipeline and test-data cleanup strategy
