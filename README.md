# Satellite Data Processing

### Install steps:
1. Create MySQL database named \`satellite_demo\`.
2. Create user 'demo'@'%' with all permissions on the satellite_demo database.
 
```sql
CREATE USER 'demo'@'%' IDENTIFIED BY 'demo-P@ssw0rd';
GRANT ALL PRIVILEGES ON `satellite_demo`.* TO 'demo'@'%';
FLUSH PRIVILEGES;
```

3. Verify MySQL access with new user credentials prior to executing the application.
4. On first run, the application will generate the MySQL table \`flyway_schema_history\`, which will store database migration details. It will also execute all migrations that have not been implemented.
5. Flyway migrations are stored in the resources/db/mysql/migration folder.
6. Web application will run using port 8080, please make sure no other applications are running using this port. 


