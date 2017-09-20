# Task 1


## Installing

- Open terminal/command line
```code
  cd account

  mvn spring-boot:run
```
## Api detail
#### Get Account
- Url: http://localhost:8080/v1/accounts/account/{accountId}

- Method: GET

- Ex: http://localhost:8080/v1/accounts/account/1

#### Get All Account
- Url: http://localhost:8080/v1/accounts/account

- Method: GET

#### Create account
- Url: http://localhost:8080/v1/accounts/account

- Method: POST

- Example body:

```json
{
        "customerName": "Phong",
        "currency": "VND",
        "amount": 150300000
}
```

#### Update account
- Url: http://localhost:8080/v1/accounts/account/{accountId}

- Method: PUT

- Ex: http://localhost:8080/v1/accounts/account/1


- Example body:

```json
{
        "customerName": "Phong",
        "currency": "VND",
        "amount": 150300000
}
```

