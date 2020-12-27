CREATE TABLE `clients` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `register_date` date DEFAULT NULL,
  `document` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `clients` VALUES (1,'2020-12-11','78461080','rafael@gft.com','Rafael Borges','123567'),(2,'2020-12-11','845547','eike@gft.com','Raul Eike','123567'),(3,'2020-12-11','845313447','henrique@gft.com','Henrique Vergara','123567'),(4,'2020-12-11','45676447','messias@gft.com','Messias','123567');