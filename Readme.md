
# Introduction
This is a simple Spring Boot app meant to be a simple duplication of the IMDB database and rest api

# Assumptions and Limitations
1. Our movie theater is basically the TARDIS from Doctor Who; small on the outside with infinite number of theater rooms on the inside.
2. I realized at the very end that OMDB is not a renaming of IMDB and that you wanted me to interact via rest with that API.  
   I ended up creating a whole persistence layer for everything...I think it demonstrates my skill level just the same or as better.
   In order to interact with the actual OMDB REST API, it would have been a simple matter of using a RestTemplate.
3. I took a lot of simplicity in the schema design in the database.  I tried to demonstrate understanding and not fully normalize the data.
4. I didn't write any tests due to time.

# Setup

This project requires Docker.  Please install if you do not have already.  Instructions for installing Docker can be found here:  https://docs.docker.com/get-docker/

1. Clone the repo:  https://github.com/mjohns39/omdb.  Change directory to the project root
2. Run the command `docker-compose pull`   
3. Run the command `docker-compose up -d localdb`.  Wait ~10 seconds to allow the database to startup
4. Run the command `bash src/main/resources/setup_scripts/setup_database.sh`
5. Run the command `docker-compose up -d`
6. Optionally, you can tail the logs with `docker-compose logs -f`

# Interaction

1. This API uses HTTP Basic Authentication for Internal Endpoints.  
   The default username and password are `admin` and `WillBaumann365` respectively.
   These can be changed in `src/main/resources/application.yml`, `spring:security:user:name` and `spring:security:user:password`
   All other endpoints bypass Authentication for simplicity
2. This API uses Spring Data Rest and follows the HATEOAS specification.  The root api url is `localhost:8080`.
   You can browse the HATEOAS endpoints vis a vi
3. This API features Swagger.  You can access the Swagger UI via `localhost:8080/swagger-ui/`.  
   Enter the username and password when prompted.
   
# Key Features/Endpoints

Outlined here are the core endpoints specified.
1. An internal endpoint in which they (i.e. the cinema owners) can update show times and prices for their movie catalog.
   *This requires knowing the username and password*
2. An endpoint in which their customers (i.e. moviegoers) can fetch movie times
3. An endpoint in which their customers (i.e. moviegoers) can fetch details about one of their movies (e.g. name, description, release date, rating, IMDb rating, and runtime).
4. An endpoint in which their customers (i.e. moviegoers) can leave a review rating (from 1-5 stars) about a particular movie
5. An endpoint where customers can search for movies that have their favorite actor/actress.

## Internal Endpoint
```
curl --location --request POST 'localhost:8080/movieShowtimes' \
--header 'Authorization: Basic YWRtaW46V2lsbEJhdW1hbm4zNjU=' \
--header 'Content-Type: application/json' \
--data-raw '{
    "movieId": 1,
    "dayOfWeek": 1,
    "minuteOfDay": 720,
    "price": 11.50
}'
```

## Get Movie Times

First, lookup movieId by title
```
curl --location --request GET 'localhost:8080/movies/search/findByTitle?title=The%20Fast%20and%20the%20Furious'
```
Second, lookup movie showtimes
```
curl --location --request GET 'localhost:8080/movieShowtimes/search/findByMovieId?movieId=1'
```

## Get Movie Details
```
curl --location --request GET 'localhost:8080/movies/search/findByTitle?title=The%20Fast%20and%20the%20Furious'
```

## Customer Rate Movie
*Note*.  You need to have a user created first.
```
curl --location --request POST 'localhost:8080/userRatings' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": {
        "userId": 1,
        "movieId": 1
    },
    "rating": 5
}'
```

## Search for movies by actor
```
curl --location --request GET 'localhost:8080/movies/search/findByActorsContaining?actor=Diesel'
```