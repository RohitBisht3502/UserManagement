# <h1 align = "center">  User Management API </h1>
___ 
<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.3-brightgreen.svg" />
</a>
    <img alt = "License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
    </a>
</p>


---

<p align="left">

## Overview

The User Management API is a Spring Boot-based web application designed to facilitate the management of users. It provides endpoints for performing operations related to user management, such as creating new users, updating user information, and deleting user accounts and many more.
## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven
- **Database:** MySql
  
## Controller

The Controller layer is responsible for handling incoming HTTP requests and delegating them to the appropriate services. It defines API endpoints for the following operations:

## User Management API Endpoints

### Create User
- **Method**: POST
- **Endpoint**: /user/create
- **Description**: Creates a new user with the provided attributes.
- **Request Body**: User object containing user details.
- **Response**: Success message upon successful user creation.

### Create Manager
- **Method**: POST
- **Endpoint**: /manager/create
- **Description**: Creates a new manager with the provided attributes.
- **Request Body**: Manager object containing manager details.
- **Response**: Success message upon successful manager creation.

### Get All Managers
- **Method**: GET
- **Endpoint**: /managers/all
- **Description**: Retrieves all managers from the database.
- **Response**: List of Manager objects.

### Get All Users
- **Method**: GET
- **Endpoint**: /users/all
- **Description**: Retrieves all users from the database.
- **Response**: List of User objects.

### Get Users by Manager ID
- **Method**: GET
- **Endpoint**: /users/by-manager/{managerId}
- **Description**: Retrieves all users belonging to the specified manager.
- **Request Parameter**: managerId (Long)
- **Response**: List of User objects filtered by manager ID.

### Get User by Contact Number
- **Method**: GET
- **Endpoint**: /users/by-phone/{phoneNumber}
- **Description**: Retrieves the user with the specified contact number.
- **Request Parameter**: phoneNumber (String)
- **Response**: User object.

### Bulk Update Users
- **Method**: PUT
- **Endpoint**: /users/update/bulk
- **Description**: Updates multiple users with the provided data.
- **Request Body**: UpdateRequest object containing user IDs and update data.
- **Response**: Success message upon successful user updates.

### Delete User by ID
- **Method**: DELETE
- **Endpoint**: /user/delete/{userId}
- **Description**: Deletes the user with the specified user ID.
- **Request Parameter**: userId (UUID)
- **Response**: Success message upon successful user deletion.

### Delete User by Contact Number
- **Method**: DELETE
- **Endpoint**: /user/delete/by-phone/{phoneNumber}
- **Description**: Deletes the user with the specified contact number.
- **Request Parameter**: phoneNumber (String)
- **Response**: Success message upon successful user deletion.
  
## Services

The Services layer implements the core business logic, data processing, and interaction with the data repository. Key responsibilities include:

- Validating input data.
- Performing CRUD operations on user data.
- Handling data transformations and interactions with external systems (if applicable).

## Repository

The Repository layer manages data access to the underlying database. It handles database operations such as Create, Read, Update, and Delete (CRUD) for user data. Additionally, it may include data mapping and conversion between Java objects and database entities.

## User Class

The `User` class defines the structure for user data and includes the following fields:

- `userId` (Type: UUID): An identifier for the user.
- `userName` (Type: String): The user's full name.
- `contactNumber` (Type: String): The user's contact number.
- `userPanNumber` (Type: String): The user's PAN number (Permanent Account Number). Must be a valid PAN number (e.g., AABCP1234C).
- `createdAt` (Type: LocalDateTime): The timestamp indicating when the user was created. This field is not updatable.
- `updatedAt` (Type: LocalDateTime): The timestamp indicating when the user was last updated.
- `manager` (Type: Manager): The manager associated with the user.
## Manager Class

The `Manager` class defines the structure for manager data and includes the following fields:

- `managerId` (Type: Long): An identifier for the manager.
- `managerName` (Type: String): The manager's full name.
- `managerContactNumber` (Type: String): The manager's contact number
- `managerEmail` (Type: String): The email address associated with the manager's account.

- ...
## Mapping

The `User class` mappings are likes Many users have one manager:

- @ManyToOne
- @JoinColumn(name = "fk_manager_id")
- private Manager manager;



## MySql

The project utilizes the `MYSql` database to store and manage lists of `users` ,`manager` objects in various parts of the application. `MySql` provides permanent storage and efficient element retrieval, making it suitable for storing blog records and performing operations on them.

These database enable the application to organize and manipulate blog data efficiently while maintaining data integrity.

## Project Summary

The User Management API provides a comprehensive solution for managing user data through a user-friendly interface and a robust backend infrastructure. Built on Spring Boot, the system offers scalability, reliability making it suitable for a wide range of user management applications.

Key Features:

- RESTful API endpoints for user management.
- Data validation to ensure data integrity.
- Clean code separation with a layered architecture (Controller, Services, Repository).
- Robust error handling for improved reliability.
- Java-based backend and Maven for build management.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgments

Thank you to the Spring Boot and Java communities for providing excellent tools and resources.

## Contact
For questions or feedback, please contact [Rohit singh bisht](mailto:business.rohitbisht3502@gmail.com)
