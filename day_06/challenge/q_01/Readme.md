# Project Question

## Overview

Build a web application that facilitates POST and GET operations for pagination and sorting employee details via RESTful APIs.

## Functional Requirements:

- Create folders named as controller, model, repository and service inside the WORKSPACE/springapp/src/main/java/com/example/springapp.

- Inside the controller folder, create a class named “EmployeeController”.

- Inside model folder, create a class named "Employee" with the following attributes:

  ```java
  employeeId - int
  employeeName - String
  employeeEmail -  String
  employeeMobile - String
  ```

- Implement getters, setters and constructors for the corresponding attributes.

- Inside repository folder, create an interface named "EmployeeRepo".

- Inside service folder, create a class named "EmployeeService".

### Refer the below image for the project structure:

![alt text](image.png)

## API Endpoint :

- `POST -  /api/employee` - Returns response status 201 with employee object on successful creation or else 500.

- `GET - /api/employee/sortBy/{field}` - Returns response status 200 with List<Employee> sorted objects, where {field} denotes the attribute name to be sorted in ascending order on successful retrieval or else 404.

- `GET - /api/employee/{offset}/{pagesize}` - Returns response status 200 with List<Employee> sorted objects, where {offset} denotes the starting index of the page, {pagesize} represents the number of employees per page on successful retrieval or else 404.

- `GET - /api/employee/{offset}/{pagesize}/{field}` - Returns response status 200 with List<Employee> sorted objects, where {offset} denotes the starting index of the page, {pagesize} represents the number of employees per page, and {field} indicates the attribute name to be sorted in ascending order on successful retrieval or else 404.

### Note:

Do not modify the `application.properties` and `pom.xml` files. If you change there may be build failure and the test case will fail. Follow the naming convention as specified above.

## API endpoint:

8080

## Platform Guidelines:

To run the project use Terminal in the platform.

## Spring Boot:

Navigate to the springapp directory => `cd springapp`

To start/run the application `'mvn spring-boot:run'`

### To Connect the Database Open the terminal

```sh
mysql -u root --protocol=tcp -p
password:examly
```

**Note: Drop database before running test case**

Click on the Run Test Case button to pass all the test cases
