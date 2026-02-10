# CineTrace API

CineTrace is a Spring Boot backend designed to manage movie reviews. It integrates seamlessly with **The Movie Database (TMDB) API** to fetch real-time movie data while providing a local persistence layer for user-generated reviews.

Check out the **[CineTrace Flutter app](https://github.com/om1cael/CineTrace)**.

## 🚀 Features

* **Movie Discovery**: Fetch popular movies directly from TMDB.
* **Search**: Search for specific titles across the TMDB database.
* **Detailed Information**: Retrieve metadata for individual movies (ID, title, overview, release date, etc.).
* **User Reviews**:
  -  Create and persist reviews for specific movies.
  -  Validation for ratings (0-5 stars) and content length.
  -  Fetch all reviews associated with a specific movie ID.

## 🛠️ Tech Stack

* **Java**
* **Spring Boot**
* **Gradle**
* **Spring Data JPA**
* **OpenFeign**
* **Lombok**
* **H2**

## 📋 API Endpoints

### Movies

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/api/v1/movies/popular` | Get a list of current popular movies. |
| `GET` | `/api/v1/movies/{id}` | Get detailed info about a specific movie. |
| `GET` | `/api/v1/movies/search?query=...` | Search for movies by title. |

### Reviews

| Method | Endpoint | Description |
| --- | --- | --- |
| `POST` | `/api/v1/reviews` | Post a new review for a movie. |
| `GET` | `/api/v1/reviews/{movieId}` | Get all user reviews for a specific movie. |

## ⚙️ Setup & Installation

### Prerequisites

* **JDK 17** or higher.
* A **TMDB API Key** (Bearer Token).

### Configuration

1. Clone the repository:
```bash
git clone https://github.com/om1cael/cinetrace-api.git
```


2. Define your TMDB API Key in your environment variables:
```properties
API_KEY=your_tmdb_bearer_token_here
```

### Running the application

Using the Gradle Wrapper:

```bash
./gradlew bootRun
```

### Building the JAR

```bash
./gradlew build
```

## 🏗️ Architecture Note

The project follows a clean service-oriented architecture:

* **Clients**: Feign interfaces for external API communication.
* **Controllers**: REST endpoints for the Front-end.
* **Services**: Business logic and validation (e.g., preventing reviews for non-existent movies).
* **DTOs**: Record-based data transfer objects for efficient JSON mapping.
