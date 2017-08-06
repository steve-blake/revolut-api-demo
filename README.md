# Revolut API demo
Revolut API Demo

# Install packages

- Install Java 8
- Install Maven 3.x

# API Framework

- Dropwizard - http://www.dropwizard.io/1.1.2/docs/

# Test framework

- JUnit - http://junit.org/junit4/
- JavaHamcrest - http://hamcrest.org/JavaHamcrest/

# Test

- `mvn test`

# Run

- `mvn package`
- `java -jar target/revolut-account-api-demo-1.0-SNAPSHOT.jar server`

# API Usage

- Eg. http://localhost/account/get-all
- GET /account
- GET /account/deposit/{id}/{amount}
- GET /account/get-all
- GET /account/get/{id}
- GET /account/transfer/{fromId}/{toId}/{amount}
- POST /account/update
- GET /account/withdraw/{id}/{amount}
- GET /user
- GET /user/get-all
- GET /user/get/{id}
- POST /user/update
