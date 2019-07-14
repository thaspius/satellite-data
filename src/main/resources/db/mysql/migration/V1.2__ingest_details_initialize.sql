
CREATE TABLE `ingest_details` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `file_name` varchar(64) NOT NULL,
  `started_at` datetime NOT NULL,
  `completed_at` datetime,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
