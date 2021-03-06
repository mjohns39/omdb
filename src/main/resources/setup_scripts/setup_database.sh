
#Step 1:  Copy scripts to container
docker cp src/main/resources/db_scripts omdb_localdb_1:/

#Step 2:  Create Database
docker exec -it omdb_localdb_1 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P WillBaumann365 -i /db_scripts/db/create-fourthwall-db.sql

#Step 3:  Create Tables
docker exec -it omdb_localdb_1 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P WillBaumann365 -i /db_scripts/ddl/10-create-movies-table.sql
docker exec -it omdb_localdb_1 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P WillBaumann365 -i /db_scripts/ddl/20-create-users-table.sql
docker exec -it omdb_localdb_1 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P WillBaumann365 -i /db_scripts/ddl/30-create-critics-ratings-table.sql
docker exec -it omdb_localdb_1 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P WillBaumann365 -i /db_scripts/ddl/40-create-user-ratings-table.sql
docker exec -it omdb_localdb_1 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P WillBaumann365 -i /db_scripts/ddl/50-create-movie-showtimes-table.sql

#Step 4:  Populate initial data
docker exec -it omdb_localdb_1 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P WillBaumann365 -i /db_scripts/dml/10-populate-movies-data.sql
docker exec -it omdb_localdb_1 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P WillBaumann365 -i /db_scripts/dml/20-populate-critics-ratings-data.sql