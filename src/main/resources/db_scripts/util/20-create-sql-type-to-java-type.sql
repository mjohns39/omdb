create table [fourthwall].[dbo].[sql_types_to_java_types]
(
    sql_type sysname primary key,
    java_type sysname not null
);

insert into [fourthwall].[dbo].[sql_types_to_java_types]
(sql_type, java_type)
values
('bigint', 'BigInteger'),
('binary', 'byte[]'),
('bit', 'boolean'),
('char', 'String'),
('date', 'Date'),
('datetime', 'Date'),
('datetime2', 'ZonedDateTime'),
('datetimeoffset', 'ZonedDateTime'),
('decimal', 'Double'),
('float', 'Double'),
('image', 'byte[]'),
('int', 'Integer'),
('money', 'BigDecimal'),
('nchar', 'String'),
('ntext', 'String'),
('numeric', 'Double'),
('nvarchar', 'String'),
('real', 'Double'),
('smalldatetime', 'Date'),
('smallint', 'Integer'),
('smallmoney', 'BigDecimal'),
('text', 'String'),
('time', 'Date'),
('tinyint', 'Integer'),
('uniqueidentifier', 'UUID'),
('varbinary', 'byte[]'),
('varchar', 'String');

