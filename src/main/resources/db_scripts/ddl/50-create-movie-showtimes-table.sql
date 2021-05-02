create table [fourthwall].[dbo].[movie_showtimes] (
    id int identity primary key,
    movieId int not null,
    dayOfWeek smallint not null,
    minuteOfDay smallint not null,
    price decimal(19,4) not null,
    constraint FK_movie_showtimes_movie foreign key (movieId) references movies (id)
                    on delete cascade
                    on update cascade,
    constraint UQ_movie_showtimes_showing unique (movieId, dayOfWeek, minuteOfDay),
    constraint CHK_movie_showtimes_dayOfWeek check (dayOfWeek between 0 and 6),  --0: sunday, 6: saturday
    constraint CHK_movie_showtimes_minuteOfDay check (minuteOfDay between 0 and 1439), --0: 00:00, 1439: 23:59
    constraint CHK_movie_showtimes_price check (price > 0)
)