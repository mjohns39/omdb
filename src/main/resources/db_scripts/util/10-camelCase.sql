
CREATE FUNCTION [dbo].[camel_case]
(
    @str varchar(max)
)
RETURNS varchar(max)
WITH RETURNS NULL ON NULL INPUT, SCHEMABINDING
AS
BEGIN

   SET @str = Lower(@str);
   WHILE Left(@str, 1) = '_'
      SET @str = Right(@str, Len(@str) - 1);

   DECLARE @i int = 0;

   WHILE 1 = 1 BEGIN
      SET @i = CharIndex(N'_', @str, @i + 1);
      IF @i IS NULL OR @i = 0 OR @i = Len(@str)
         BREAK;
      ELSE
         SET @str = Stuff(@str, @i, 2, Upper(Substring(@str, @i + 1, 1)));
   END;

   RETURN @str;

END