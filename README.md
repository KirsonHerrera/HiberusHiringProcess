# Hiberus Hiring Technical Test

This project is a technical test for Hiberus Hiring. It is a Spring Boot application that provides RESTful APIs for managing offers.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Running Tests](#running-tests)
- [API Endpoints](#api-endpoints)
- [Built With](#built-with)
- [About use of Hexagonal Architecture in my code](#about-use-of-hexagonal-architecture-in-my-code)
- [Google_Drive_Link](#google-drive-link)
- [Authors](#authors)
- [License](#license)

## Getting Started

These instructions will help you set up and run the project on your local machine for development and testing purposes.

## Prerequisites

- Java 11-17 or higher
- Maven 3.6.0 or higher

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/KirsonHerrera/hiberus-hiring-technical-test.git
    ```
2. Navigate to the project directory:
    ```sh
    [project-dir]
    ```

## Running the Application

To run the application, use the following command:
 ```sh
  mvn spring-boot:run
 ```



The application will start and be accessible at `http://localhost:8080/hiberus/api/v1`.

## Running Tests

To run the tests, use the following command:
 ```sh
  mvn test
 ```



## API Endpoints

### Get All Offers
- **URL:** `/hiberus/api/v1/offer`
- **Method:** `GET`
- **Response:** `200 OK`

### Get Offer by ID
- **URL:** `/hiberus/api/v1/offer/{id}`
- **Method:** `GET`
- **Response:** `200 OK`

### Create Offer
- **URL:** `/hiberus/api/v1/offer`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "id": 1,
        "offer": {
            "brandId": 1,
            "productPartnumber": "123"
        }
    }
    ```
- **Response:** `201 Created`

### Delete Offer by ID
- **URL:** `/hiberus/api/v1/offer/{id}`
- **Method:** `DELETE`
- **Response:** `200 OK`

### Delete All Offers
- **URL:** `/hiberus/api/v1/offer`
- **Method:** `DELETE`
- **Response:** `200 OK`

### Get Time Table
- **URL:** `/hiberus/api/v1/brand/{brandId}/partnumber/{partnumber}/offer`
- **Method:** `GET`
- **Response:** `200 OK`

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework for building Java applications
- [Maven](https://maven.apache.org/) - Dependency management

## About use of Hexagonal Architecture in my code


### Domain Layer (Core Business Logic):
This layer contains the core business logic and domain entities. In my case, it would include the Offer entity and any business rules related to offers.
### Application Layer (Use Cases):
This layer contains the application-specific logic, such as use cases and services that orchestrate the business logic. In my code, the OfferInfraService would be part of this layer, as it provides methods to handle offers.
### Adapters (Infrastructure):
Adapters are responsible for communicating with external systems. They implement the interfaces defined by the core application. In my code, the OfferController acts as an adapter for the web layer, handling HTTP requests and responses.
### Ports (Interfaces):
Ports are interfaces that define the operations that can be performed by the core application. They are implemented by the adapters. In my code, the methods in OfferInfraService can be considered as ports.

### Explanation of my Code

#### OfferController:

This is an adapter that handles HTTP requests and responses. It uses the OfferInfraService to perform operations related to offers. It is part of the infrastructure layer.

#### OfferInfraService:

This service contains the application-specific logic for handling offers. It interacts with the domain layer and performs operations such as creating, fetching, and deleting offers. It acts as a port in the hexagonal architecture.

#### TechnicalTestApplicationTests:

This class contains test cases for the OfferController. It uses MockMvc to simulate HTTP requests and verify the responses. These tests ensure that the controller behaves as expected.

### Code Structure in Hexagonal Architecture

#### Domain Layer:

Offer (Domain Entity)

#### Application Layer:

OfferInfraService (Application Service)

#### Adapters (Infrastructure Layer):

OfferController (Web Adapter)

#### Tests:

TechnicalTestApplicationTests (Integration Tests)

## Google Drive Link

Follow this link https://drive.google.com/drive/folders/1D4kmNgtQewIFiQ2KcgQIvNGXGmk2Nl2R?usp=drive_link

## Authors

- **Kirson Herrera** - [KirsonHerrera](https://github.com/KirsonHerrera)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
