# Stock Handling Application

In an online shop we would like to provide for all available products the stock data. Additionally
for analytic reasons, we also want to keep track on some basic statistics. 

In this application I have 3 Entity:

1. **Product** : the **Product** entity created for holding data about each product
2. **Sale**: the **Sale** entity save records of selling product.
3. **Stock**: The **Stock** entity hold in availability of product

------
## Stack

- Docker
- Java
- Spring Boot
- Mysql
- Maven
- Git

------

## What you'll need

Docker-ce and docker-compose

For installing docker you can use this 

[Link]: https://docs.docker.com/install/

after installing docker and docker-compose you need just run this:

## Run

In this Project I use docker-compose for building my application through maven and next build docker image and also running a Mysql container.

- Clone the Project
- Run command `docker-compose up` in the root folder
- Access to http://localhost:8432

------

## EndPoints

 1. **updates the current stock of a particular product** 

    ```
    POST http://localhost:8432/updateStock
    ```

    with body:‍‍‍

    ```
    {
    	"id":"00001",
    	"timestamp" : "2017-07-17T22:54:01.754Z",
    	"productId":"vegetable-123"	,
    	"quantity":"6600"
    }
    ```

    and header:

    ```
    Content-Type:application/json
    ```
    
    

2. **get the current stock available of a particular product.** 

   ```
   GET http://localhost:8432/stock?productId=vegetable-123
   ```

   with this query parameter:
   
   ```
   productId=vegetable-123
   ```
   
   with any value that you want
   
   Response should be like this:
   
   ```
   {
       "productId": "vegetable-123",
       "requestTimestamp": "2019-05-29T09:30:46.397+0000",
       "stock": {
           "id": "00001",
           "quantity": 6600,
           "timestamp": "2017-07-17T22:54:01.754+0000"
       }
   }
   ```
   
   

3. **Statistics about stocks back. The available timespans are today (midnight until now) and last month .**

   ```
   GET http://localhost:8432/statistics?time=today
   ```

   with this query parameter:

   ```
   time=today
   ```

   also the available value are : **today** and **lastMonth**

   Response should be like this:

   ```
   {
       "requestTimestamp": "2019-05-30T14:36:59.296",
       "range": "lastMonth",
       "topAvailableProducts": [
           {
               "id": "00001",
               "timestamp": "2019-04-17T22:54:01.754",
               "productId": "vegetable-123",
               "quantity": 6600
           },
           {
               "id": "00003",
               "timestamp": "2019-04-17T22:54:01.754",
               "productId": "apple6",
               "quantity": 5000
           },
           {
               "id": "00002",
               "timestamp": "2019-04-24T22:54:01.754",
               "productId": "apple5",
               "quantity": 1000
           }
       ],
       "topSellingProducts": [
           {
               "productId": "vegetable-123",
               "itemsSold": 70
           },
           {
               "productId": "apple1",
               "itemsSold": 15
           },
           {
               "productId": "apple5",
               "itemsSold": 10
           }
       ]
   }
   ```

   # Notice

   In resource folder in project create a `data.sql` file containing data and each time the application run these data push to the DB.if you don't want put this data you can change it in application.yaml from 
   
   ```
   spring:
       datasource:
           initialization-mode: always
   ```
   
   to:
   
   ```
   spring:
       datasource:
           initialization-mode: never
   ```
   
   