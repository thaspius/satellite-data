
CREATE TABLE `satellites` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `sat_number` varchar(8) NOT NULL,
  `specific_measurement` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `sat_number` (`sat_number`)
) ENGINE=InnoDB 