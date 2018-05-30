# Spring-MySQL 

Basic aplication with Spring Boot, Swagger and Lombok connecting to MySQL database

## Running Server

### Prerequisits

1. JAVA installed properly
2. MySQL is running
3. Connect to MySQL server and do following comands:
```sql
mysql> create database db_example; -- Create the new database
mysql> create user 'springuser'@'localhost' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'localhost'; -- Gives all the privileges to the new user on the newly created database
```
### Steps

1. Navigate into project directory 
2. Execute `gradlew bootRun`
3. Go to localhost:8080/swagger-ui.html and try it

