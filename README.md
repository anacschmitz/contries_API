# Countries & Cities API

This API project aims to deliver information about the cities of a country you would like to
search, and details about a specific city of your choice — such as area, population, and the
zip code of the principal office.

An OpenAPI (Swagger) documentation is available to guide you through the available endpoints.

## Stack

- Java 21
- Spring Boot 4.1
- springdoc-openapi 2.5.0 (OpenAPI / Swagger UI)
- H2 Database (in-memory, default)
- PostgreSQL 16 (containerized)
- Docker 20.10+
- Docker Compose v2

## Requirements

- Java 21
- Maven

**Optional** (only required if you want to run via Docker / with PostgreSQL):
- Docker 20.10+
- Docker Compose v2

## How to Start

By default, the application uses the **H2 Database**, an in-memory database that only exists
during the application's runtime. The database is populated with sample data when the
application starts, and **all data is lost once the application stops**.

### Option 1 — Run locally (H2, no Docker)

```bash
mvn spring-boot:run
```

- Default port: `8081`
- No persistence — data resets on every restart.

### Option 2 — Run with Docker (PostgreSQL, persistent data)

Build the images and start both the API and the database containers:
```bash
docker compose up -d --build
```

Stop the containers **without** deleting the data created:
```bash
docker compose down
```

Stop the containers **and** delete the data created:
```bash
docker compose down -v
```

**Optional:** run only the PostgreSQL container (useful if you want to run the API locally via
`mvn spring-boot:run`, but against a real persistent database):
```bash
docker compose up -d postgres
```

## API Documentation (Swagger / OpenAPI)

Once the application is running, the documentation is available at:

- **Swagger UI**: http://localhost:8081/swagger-ui.html
- **Raw OpenAPI spec (JSON)**: http://localhost:8081/v3/api-docs

## Endpoints

| Method | Path | Description |
|--------|------|--------------|
| `GET` | `/api/v1/countries` | List all countries |
| `GET` | `/api/v1/cities/{countryId}` | List all cities for a specific country, by country ID |
| `GET` | `/api/v1/cities/countryName/{countryName}` | List all cities for a specific country, by country name |
| `GET` | `/api/v1/cities/detail/{cityId}` | Get details of a specific city, by city ID |

## Example Requests

```bash
# List all countries
curl http://localhost:8081/api/v1/countries

# List cities for a given country id
curl http://localhost:8081/api/v1/cities/1

# List cities for a given country name
curl http://localhost:8081/api/v1/cities/countryName/Brazil

# Get details of a specific city
curl http://localhost:8081/api/v1/cities/detail/1
```
