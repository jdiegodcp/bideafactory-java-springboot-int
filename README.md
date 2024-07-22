# Spring Boot Project with PostgreSQL and Docker

## Overview

This is a Spring Boot project that connects to a PostgreSQL database to save the booking's realized through the endpoint /bidefactory/book. The project is configured to be run using Docker and Docker Compose, which simplifies the management of both the application and the database.

## Features

- RESTful API 
    POST
    endpoint : /bidefactory/book   -- required
    GET
    endpoint : /bidefactory/books  -- contributed , to facilitate the view of the data saved

- Connects to PostgreSQL
- Dockerized setup with Docker Compose

## Prerequisites

- Docker
- Docker Compose
- IDE IntelliJ  -- suggested to manage environment variables or any other IDE that can allow you to do that

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/yourusername/your-repository.git
cd your-repository
#  With the use of an IDE or manually generate the JAR corresponding to the project and then run the next command
docker compose up -d 
# Depending how much capacity the Computer where this is going to run it can take a few couple minutes to more.

# After Spring has started inside the container you can request to the following endpoints:


base_url : http://localhost:8080

GET

{{base_url}}/bideafactory/books


POST

{{base_url}}/bideafactory/book

# If you don't know how to look inside the container, it's fine to just request to the first endpoint until it shows [] which is going to be the list of bookings made, at the beginning we won't have any booking.

# If we need to develop we can just run the postgres container and develop locally comenting all the service "bookingapi", of course using environment variables to keep the variables open so whenever we need to deploy our solution using Docker and docker compose we can just push changes and uncomment the springboot service called "bookingapi".

# In case we don't want to use any IDE that facilitate the use of environment variables we can use the actual values of the variables that right now have a variable to be called by docker compose.


## Fixes after the limit time ,

Changes made on develop were necessary to clean up small details and also allow to just execute docker compose up -d wherever the repo is clonned without needing to generate the jar , it's going to generate it on the the app container itself.