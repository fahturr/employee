# Employee Service

---

This application is a **Spring Boot (Java)** based backend service designed to manage employee/user data. It acts as an *adapter* or *proxy* that consumes data from a third-party service (DummyJSON) and exposes it in a customized format.

## Technical Specifications

Based on the project configuration:

* **Java Version**: 17
* **Framework**: Spring Boot 3.5.9
* **Build Tool**: Gradle (Kotlin DSL)
* **External Integration**: Consumes API from `https://dummyjson.com/`

## Prerequisites

Before running the application, ensure your machine has the following installed:

1. **JDK 17** or newer.
2. Active internet connection (required as the app fetches real-time data from `dummyjson.com`).

## How to Run

You can run this application using the included **Gradle Wrapper**, so there is no need to manually install Gradle.

### 1. Clone or Download Project

Ensure you are in the project's *root* directory (where `gradlew` and `build.gradle.kts` are located).

### 2. Run the Application

Open your terminal (Command Prompt/PowerShell on Windows, or Terminal on Linux/macOS) and execute the following command:

**For Linux / macOS:**

```bash
./gradlew bootRun

```

**For Windows:**

```cmd
gradlew.bat bootRun

```

Wait for the build process to complete. By default, the application will start on port `8080`.

---

## API Documentation

The application provides an endpoint to retrieve a list of users with pagination support.

### Get List Users

Retrieves a paginated list of users. Data is fetched *live* from DummyJSON and mapped to the application's internal format.

* **URL**: `/api/users`
* **Method**: `GET`
* **Query Parameters**:
* `page` (int, optional): Page number (Default: `1`)
* `size` (int, optional): Number of items per page (Default: `10`)



#### Request Example

You can use `curl`, Postman, or a browser.

**Request:**

```bash
curl -X GET "http://localhost:8080/api/users?page=1&size=5"

```

#### Response Example

The response returns a standard JSON structure containing user data and pagination metadata.

**Response Body (200 OK):**

```json
{
  "page": 1,
  "size": 5,
  "totalItems": 208,
  "totalPages": 42,
  "data": [
    {
      "id": 1,
      "firstName": "Emily",
      "lastName": "Johnson",
      "email": "emily.johnson@x.dummyjson.com"
    },
    {
      "id": 2,
      "firstName": "Michael",
      "lastName": "Williams",
      "email": "michael.williams@x.dummyjson.com"
    },
    {
      "id": 3,
      "firstName": "Sophia",
      "lastName": "Brown",
      "email": "sophia.brown@x.dummyjson.com"
    },
    {
      "id": 4,
      "firstName": "James",
      "lastName": "Davis",
      "email": "james.davis@x.dummyjson.com"
    },
    {
      "id": 5,
      "firstName": "Emma",
      "lastName": "Miller",
      "email": "emma.miller@x.dummyjson.com"
    }
  ]
}

```

#### Response Fields Explanation

* `page`: Current page number.
* `size`: Data limit per page.
* `totalItems`: Total number of items available on the server.
* `totalPages`: Total number of pages available.
* `data`: Array of user objects containing:
* `id`: User ID.
* `firstName`: First name.
* `lastName`: Last name.
* `email`: Email address.



## Project Structure

* `src/main/java/com/epicmed/employee/api`: Contains Controllers and DTOs for the presentation layer (REST API).
* `src/main/java/com/epicmed/employee/core`: Contains Business Logic, Models, and Repository Interfaces.
* `src/main/java/com/epicmed/employee/infrastructure/adapter/thirdparty`: Contains technical implementations, such as WebClient configuration and the third-party Adapter (DummyJSON).
* `src/main/java/com/epicmed/employee/infrastructure`
    * Contains technical implementation details and framework configurations.
    * `adapter/thirdparty`: Implementation of integrations with third-party services (e.g., DummyJSON).
    * `adapter/persistence`: Contains repository implementations specifically for **database** access. This folder handles SQL queries, database entity mappings, and persistent data connections, keeping them separate from the main business logic.
