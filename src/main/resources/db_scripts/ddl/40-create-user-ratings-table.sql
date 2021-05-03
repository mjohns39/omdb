create table [fourthwall].[dbo].[user_ratings] (
    userId nvarchar(256) not null,
    movieId int not null,
    rating int,

    constraint PK_user_ratings primary key (userId, movieId),
    constraint FK_user_ratings_user foreign key (userId) references users (userId)
                    on delete cascade
                    on update cascade,
    constraint FK_user_ratings_movie foreign key (movieId) references movies (id)
                    on delete cascade
                    on update cascade,
    constraint CHK_user_ratings_rating check (rating between 1 and 5)
)

