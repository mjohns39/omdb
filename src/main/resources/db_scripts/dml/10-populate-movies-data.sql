insert into [fourthwall].[dbo].[movies]
(
 imdbID, title, releaseDate, mpaRating, runtimeInMinutes, genre, director, writers, actors, plot,
 language, country, awards, poster, metascore, imdbRating, imdbVotes, type, dvdReleaseDate, boxOfficeRevenue,
 production, website, response
 )
values
('tt0232500', 'The Fast and the Furious', '2001-06-22', 'PG-13', 106, 'Action, Crime, Thriller', 'Rob Cohen',
 'Ken Li (magazine article "Racer X"), Gary Scott Thompson (screen story), Gary Scott Thompson (screenplay), ' +
 'Erik Bergquist (screenplay), David Ayer (screenplay)', 'Paul Walker, Vin Diesel, Michelle Rodriguez, Jordana Brewster',
 'Los Angeles police officer Brian O''Conner must decide where his loyalty really lies when he becomes enamored with the street racing world he has been sent undercover to destroy.',
 'English, Spanish', 'USA, Germany', '11 wins & 12 nominations.',
 'https://m.media-amazon.com/images/M/MV5BNzlkNzVjMDMtOTdhZC00MGE1LTkxODctMzFmMjkwZmMxZjFhXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg',
 58, 6.8, 322264, 'movie', '2002-01-01', 14254295.00, 'Universal Pictures', 'http://www.thefastandthefurious.com',
 1
 )