CREATE DATABASE `first_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE DATABASE `second_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `first_db`.`table_a` (
  `id` int NOT NULL AUTO_INCREMENT,
  `table_a_col_1` varchar(45) DEFAULT NULL,
  `table_a_col_2` varchar(45) DEFAULT NULL,
  `table_a_col_3` varchar(45) DEFAULT NULL,
  `table_a_col_4` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `first_db`.`table_b` (
  `id` int NOT NULL AUTO_INCREMENT,
  `table_b_col_1` varchar(45) DEFAULT NULL,
  `table_b_col_2` varchar(45) DEFAULT NULL,
  `table_b_col_3` varchar(45) DEFAULT NULL,
  `table_b_col_4` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `second_db`.`table_c` (
  `id` int NOT NULL AUTO_INCREMENT,
  `table_c_col_1` varchar(45) DEFAULT NULL,
  `table_c_col_2` varchar(45) DEFAULT NULL,
  `table_c_col_3` varchar(45) DEFAULT NULL,
  `table_c_col_4` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `second_db`.`table_d` (
  `id` int NOT NULL AUTO_INCREMENT,
  `table_d_col_1` varchar(45) DEFAULT NULL,
  `table_d_col_2` varchar(45) DEFAULT NULL,
  `table_d_col_3` varchar(45) DEFAULT NULL,
  `table_d_col_4` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

