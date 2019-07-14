
CREATE TABLE `satellite_measurements` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `timestamp` datetime NOT NULL,
  `ionosphere_index` TINYINT UNSIGNED NOT NULL,
  `ndvi_index` TINYINT UNSIGNED NOT NULL,
  `radiation_index` DECIMAL(4,1) UNSIGNED NOT NULL,
  `sea_salinity` DECIMAL(3,1) UNSIGNED DEFAULT NULL,
  `earth_altitude` DECIMAL(5,1) UNSIGNED DEFAULT NULL,
  `vegetation_classification` VARCHAR(16) DEFAULT NULL,
  `satellite_id` int(11) UNSIGNED NOT NULL,
  `ingest_detail_id` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX (`timestamp`),
  FOREIGN KEY (satellite_id) REFERENCES satellites(id),
  FOREIGN KEY (ingest_detail_id) REFERENCES ingest_details(id)
) ENGINE=InnoDB;

