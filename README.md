# Project Documentation

## Overview
This project is a web application for employee management, built using Java, Spring Boot, and Maven. It includes functionalities for user authentication, staff management, and user registration.

## Technologies Used
- **Java**
- **Spring Boot**
  - **SpringCore**
  - **Spring MVC**
  - **Spring Data JPA**
  - **Spring Security**
  - **Spring Boot DevTools**
  - **Spring Boot Starter**
- **Hibernate**
- **Maven**
- **Thymeleaf**
- **Bootstrap**

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── org/
│   │       └── example/
│   │           └── mywebapp/
│   │               ├── controller/
│   │               │   ├── AuthController.java
│   │               │   └── StaffController.java
│   │               ├── entity/
│   │               │   ├── Staff.java
│   │               │   └── User.java
│   │               ├── exception/
│   │               │   └── StaffNotFoundException.java
│   │               └── services/
│   │                   ├── StaffService.java
│   │                   └── UserService.java
│   ├── resources/
│   │   └── templates/
│   │       ├── index.html
│   │       ├── login_form.html
│   │       ├── signup_form.html
│   │       └── staff_form.html
│   └── application.yml
└── test/
```

## Configuration
### `application.yml`
```yaml
server:
  port: 8080
  servlet:
    context-path: /api
spring:
  config:
    name: application.yml
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  datasource:
    url: jdbc:mysql://localhost:3306/userdb
    username: root
    password:
    hikari:
      maximum-pool-size: 8
    driver-class-name: com.mysql.cj.jdbc.Driver

```

## Controllers
### `AuthController.java`
Handles user authentication and registration.

### `StaffController.java`
Manages staff-related operations such as listing, creating, editing, and deleting staff.

## Templates
### `index.html`
Main page with navigation buttons for login, registration, and listing users.

### `login_form.html`
Form for user login.

### `signup_form.html`
Form for user registration.

### `staff_form.html`
Form for creating and editing staff details.

## Running the Application
1. Ensure you have Java and Maven installed.
2. Configure your MySQL database and update the `application.yml` file with your database credentials.
3. Run the application using Maven:
   ```sh
   mvn spring-boot:run
   ```
4. Access the application at `http://localhost:8080/api`.

## Conclusion
This documentation provides an overview of the project structure, configuration, and main components. For further details, refer to the source code and comments within the code files.