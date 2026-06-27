# MedIntel Backend

## Overview

This folder contains the backend application of **MedIntel**, developed using **Spring Boot (Java)**. The backend is responsible for processing business logic, exposing REST APIs, handling medicine search requests, managing inventory and order data, and communicating with the MySQL database.

## Technologies Used

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com/medintel/
│   │       ├── controller/
│   │       ├── service/
│   │       ├── repository/
│   │       ├── model/
│   │       ├── dsa/
│   │       ├── dto/
│   │       ├── config/
│   │       ├── exception/
│   │       ├── util/
│   │       └── MedIntelApplication.java
│   │
│   └── resources/
│       ├── static/
│       ├── templates/
│       └── application.properties
│
└── test/
```

## Features

* REST API Development
* Medicine Information Management
* Inventory Management
* Order Management
* MySQL Database Integration
* Layered Architecture (Controller, Service, Repository)

## Running the Backend

1. Navigate to the backend folder.

```bash
cd backend
```

2. Configure the MySQL database in `application.properties`.

3. Build the project.

```bash
mvn clean install
```

4. Run the Spring Boot application.

```bash
mvn spring-boot:run
```

The backend server will start at:

```text
http://localhost:8080
```

## API Communication

The backend exposes REST APIs that are consumed by the React frontend. These APIs handle requests such as medicine search, inventory retrieval, and order management.

