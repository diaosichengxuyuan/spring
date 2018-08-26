### test表
CREATE TABLE `test` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `name1` varchar(255) DEFAULT NULL,
  `name2` varchar(255) DEFAULT NULL,
  `name3` varchar(255) DEFAULT NULL,
  `age` smallint(6) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8