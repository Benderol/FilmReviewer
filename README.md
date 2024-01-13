# FilmReviewer

 This repository contains a simple Java REST API that serves as a basic template for building RESTful web services. The API is built using the Spring Boot framework, making it easy to set up and extend.

 ## Prerequisites

 - Java Development Kit (JDK)
 - Apache Maven
 - MySQL Database

## Database setup

Set the following settings or modify the application.properties file

- Username: root
- Password: root
- Schema name: reviewer

The API will be accessible at http://localhost:8080

## API Endpoints

### Create user
  - **Endpoint:** "/api/user/create"
  - **Method:** POST
  - **Description:** Create new user
  - **Example request:**
    ```json
      {
        "name" : "Dan"
        "username" : "benderol"
        "password" : "pass"
      }
    ```

### Change password
  - **Endpoint:** "/api/user/update/{userId}"
  - **Method:** POST
  - **Description:** Change password
  - **Example request:**
    ```json
      {
        "oldPassword" : "pass"
        "newPassword" : "password"
      }
    ```

### Delete user
  - **Endpoint:** "/api/user/delete/{userId}"
  - **Method:** DELETE
  - **Description:** Delete existing user
  - **Example:** http://localhost:8080/api/user/delete/1

### Get films
  - **Endpoint:** "/api/user/{userId}"
  - **Method:** GET
  - **Description:** Get all users films
  - **Example:** http://localhost:8080/api/user/1

### Add film
  - **Endpoint:** "/api/film/add/user/{userId}"
  - **Method:** POST
  - **Description:** Add film to user
  - **Example request:**
    ```json
      {
        "filmTitle" : "Matrix"
        "userOpinion" : "One of the best  films ever"
        "mark" : "4"
      }
    ```
    
### Update film
  - **Endpoint:** "/api/film/update/{filmId}"
  - **Method:** POST
  - **Description:** Change films mark
  - **Example request:**
    ```json
      {
        "newMark" : "5"
      }
    ```


### Delete film
  - **Endpoint:** "/api/film/delete/{filmId}/user/{userId}"
  - **Method:** DELETE
  - **Description:** Delete film
  - **Example:** http://localhost:8080/api/film/delete/2/user/1

