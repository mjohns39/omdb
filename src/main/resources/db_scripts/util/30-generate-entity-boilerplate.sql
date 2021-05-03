CREATE OR ALTER FUNCTION [dbo].[generate_entity_boilerplate]
(@entity varchar(128))
RETURNS table
as
RETURN

select top 99999999
c.column_name,
java_annotation = '@Column(name = "' + c.column_name + '")',
java_field = dbo.camel_case(c.column_name),
boilerplate =
   Concat_WS(
      Char(10),
      '@Column(name = "' + c.column_name + '")',
      'private ' + IsNull(m.java_type, 'String') + ' ' + c.column_name + ';',
       Char(10)
   ),
[rank] =
   CASE
      WHEN column_name LIKE 'id%' THEN 1
      ELSE 2
   END
from INFORMATION_SCHEMA.columns c
left outer join sql_types_to_java_types m on c.DATA_TYPE = m.sql_type
where c.TABLE_SCHEMA = 'dbo'
and c.TABLE_NAME = @entity