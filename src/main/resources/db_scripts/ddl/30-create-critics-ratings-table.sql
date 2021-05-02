create table [fourthwall].[dbo].[critic_ratings] (
    id int identity primary key,
    movieId int not null,
    source nvarchar(max) not null,
    value nvarchar(256) not null,
    constraint FK_critic_rating_movies foreign key (movieId)
                     references movies (id)
                     on delete cascade
                     on update cascade
)
