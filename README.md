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
7. Project was built using Java 11, ensure that the correct JRE is installed prior to running

### Run instructions 
1. Satellite measurements CSV file location is configured in resource/application.properties, update it to point to the import CSV
2. Main class to run is org.demo.satellite.SatelliteDataApplication

### General Information
A postman v2.1 collection was created to aid in testing the API methods. It is located in the project top level folder in file `SatelliteDemo.postman_collection.json`.

### Task 1 Solution Description
The assumption was made that the file always contains a contiguous time period per satellite so as to not require cluster detection. To calculate the elapsed time above the target area, the first and last timestamp were found using a database query. The database query then uses the first and last time to calculate the elapsed time per satellite and returns the data. This data was used to populate a custom JPA projection interface, which was used in the service class `SatelliteMeasurementService` to generate and populate display objects that were returned to the API method `api/satelliteMeasurements/satelliteTime` in class `SatelliteMeasurementResource`. 

### Task 2 Solution Description
The measurements that are common across satellites are calculated in one SQL query and each of the other three specific data types are calculated in separate queries. Each of the separate queries was created in the `SatelliteMeasurementRepository` class as custom queries that are used to populate JPA projection interfaces. The service class `SatelliteMeasurementService` is used to generate and populate display objects that were returned to the various API methods. 

The single API `api/satelliteMeasurements/satelliteCommonMetrics` was created to provide the max/min/avg values for the common set of metrics for Ionosphere, NDVI, and Radiation Indices. 

The three separate APIs below were created for the specific graphical presentations for the Earth altitude, vegetation type percentage, and sea salinity.
1. `api/satelliteMeasurements/satelliteEarthAltitude`
2. `api/satelliteMeasurements/satelliteVegetationClassificationPercentages`
3. `api/satelliteMeasurements/satelliteSeaSalinity`

### Task 3 Solution Description
The service class `SatelliteMeasurementService` uses the same SQL query methods and projection interface used for the satellite common metrics. Average metrics classes per metric were created that extend a common base abstract class, which provides common comparison logic for sorting the classes once populated into a List. The common metrics classes were used to populate the specific average metrics arrays per metric category, which were then sorted and added to a Map containing all three metric types. This output Map was then used in the API method `api/satelliteMeasurements/satelliteMeasurementAveragesSorted`.

### Task 4 Solution Description
Task 4 was completed first in order to leverage database queries for statistics calculations required for tasks 1 through 3. The library Flyway was used to generate the database table structures and populate the satellites table with the four satellites used in the demo. JPA repositories and entity objects were then created to manage database interactions. The repositories were then autowired into the application's main class to populate the `ingest_details` and `satellite_measurements` table with data from the imported CSV file. This was accomplished in the SatelliteDataApplication class function importSatelliteMeasurements, which parses the CSV file and initiates the construction of required entity objects for persistence to the database.

Database credentials and the ingested satellite measurements CSV file name are retrieved from the application.properties configuration file. 


