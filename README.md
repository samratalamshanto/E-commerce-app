# E-commerce-app

## Framework Details:

- Spring Boot 3.2.2
- JDK 21
- Latest docker version
- PostgresSql as Database
- Slf4j for logging 
- JUnit for testing

# Docker Files:

- **docker-compose.yml**
- **Dockerfile**


# Postman Collection:

- **Demo E-Commerce App.Postman_collection.json**

# API Details:

- **Task 1**: Create an API to return the wish list of a customer.
- **End Point**: {{base-url}}/get-wish-list?customerId=**inputCustomerId**
- **Response**:
- If Customer exits:
```
{
    "code": 200,
    "message": "Get wish list data successfully",
    "data": [
        {
            "createdAtDt": "2024-04-27T12:55:49.000+00:00",
            "createdBy": null,
            "createdByUserName": null,
            "updatedAtDt": null,
            "updatedBy": null,
            "updatedByUserName": null,
            "deletedAtDt": null,
            "deletedBy": null,
            "deletedByUserName": null,
            "id": 1,
            "productId": 1,
            "productName": "Bag",
            "productDescription": "Bag",
            "productPrice": 100.0,
            "customerId": 1,
            "customerName": "samrat",
            "status": "Active"
        }
    ]
}
```
- If Customer Doesn't Exit:
```
{
    "code": 500,
    "message": "com.example.demo_ecommerce_app.exception.CustomerNotFoundException: Customer Not Exits.",
    "data": null
}
```

- **Task 2**: Create an API to return the total sale amount of the current day.
- **End Point**: {{base-url}}/get-total-sales-amount
- **Response**:
```
{
    "code": 200,
    "message": "Successfully get total sell amount",
    "data": 1540.0
}
```

- **Task 3**: Create an API to return the max sale day of a certain time range.
- **End Point**: {{base-url}}/get-max-sale-certain-time-range?fromDate=**inputFromDate**&toDate=**inputToDate**
- **Response**:
```
{
    "code": 200,
    "message": "Successfully get max sell date of certain dates.",
    "data": [
        "2024-04-27"
    ]
}
```
- If dates are not proper format or empty, the response will be:
```
{
    "code": 500,
    "message": "java.lang.RuntimeException: com.example.demo_ecommerce_app.exception.DateFormatException: Date was not proper format.yyyy-MM-dd format required.",
    "data": null
}
```

- **Task 4**: Create an API to return top 5 selling items of all time (based on total sale amount).
- **End Point**: {{base-url}}/get-top-five-sells-product
- **Response**:
```
{
    "code": 200,
    "message": "Successfully get total sell amount",
    "data": [
        {
            "productName": "Keyboard",
            "totalSellAmount": 2000.0,
            "totalUnit": 4
        },
        {
            "productName": "Mouse",
            "totalSellAmount": 420.0,
            "totalUnit": 7
        },
        {
            "productName": "Bag",
            "totalSellAmount": 300.0,
            "totalUnit": 3
        }
    ]
}
```

- **Task 5**: Create an API to return top 5 selling items of the last month (based on number of sales).
- **End Point**: {{base-url}}/get-last-month-top-five-sells-product-based-on-unit
- **Response**:
```
{
    "code": 200,
    "message": "Successfully get total sell of last month based on total unit.",
    "data": [
        {
            "productName": "Mouse",
            "totalSellAmount": 180.0,
            "totalUnit": 3
        },
        {
            "productName": "Keyboard",
            "totalSellAmount": 1000.0,
            "totalUnit": 2
        }
    ]
}
```

# Instructions: 
- **First clone the project**. 
- **Run the command _"docker compose up"_**. 
- **Test endpoints using the given Postman collection**.

