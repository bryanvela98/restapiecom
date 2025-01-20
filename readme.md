# Football Field Booking API

This project provides an API for managing football field bookings. It includes functionality for creating, reading, and managing football fields, districts, and clients. The backend is developed using **Spring Boot** and uses **JPA** for database interaction.

## Features

- **Football Field (Cancha)**: Add, update, and retrieve football fields.
- **District (Distrito)**: Add and retrieve districts.
- **Client (Cliente)**: Add and retrieve clients.

## Technologies Used

- **Spring Boot** for backend development.
- **JPA (Java Persistence API)** for database interaction.
- **Spring Data JPA** for repository support.
- **H2 Database** (or any relational database of your choice) for persistence.

## Endpoints

### 1. Football Field (Cancha)

- **POST** `/api/canchas`: Create a new football field.

  **Request Body Example**:

  ```json
  {
    "nombre": "Field A",
    "distrito": "District 1",
    "disponible": true
  }
  ```

- **GET** `/api/canchas`: Retrieve all football fields.

  **Request Body Example**:

  ```json
  [
    {
      "id": 1,
      "nombre": "Field A",
      "distrito": "District 1",
      "disponible": true
    },
    {
      "id": 2,
      "nombre": "Field B",
      "distrito": "District 2",
      "disponible": false
    }
  ]
  ```

### 2. Client (Cliente)

- **POST** `/api/clientes`: Create a new client.

  **Request Body Example**:

  ```json
  {
    "id": 1,
    "nombre": "John Doe"
  }
  ```

- **GET** `/api/clientes`: Retrieve all clients.

  **Request Body Example**:

  ```json
  {
    "id": 1,
    "nombre": "John Doe"
  }
  ```

### 3. District (Distrito)

- **POST** `/api/distritos`: Create a new district.

  **Request Body Example**:

  ```json
  {
    "id": 3,
    "nombre": "San Miguel"
  }
  ```

- **GET** `/api/distritos`: Retrieve all districts.

  **Request Body Example**:

  ```json
  {
    "id": 1,
    "nombre": "John Doe"
  }
  ```

## Project Setup

- JDK 11 or above.
- Maven for dependency management.
- H2 Database (or any relational database of your choice).
