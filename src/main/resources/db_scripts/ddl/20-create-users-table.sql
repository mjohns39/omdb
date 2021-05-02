create table [fourthwall].[dbo].[users] (
    userId nvarchar(256) primary key,
    firstName nvarchar(256) not null,
    lastName nvarchar(256) not null,
    email nvarchar(256) not null unique
)