CREATE TABLE `fornecedor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rihyjxxhmgutledr1hdl5gpi8` (`cnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `fornecedor` VALUES (1,'15.436.940/0001-03','Amazon'),(2,'33.014.556/0001-96','Americanas'),(3,'00.623.904/0001-73','Apple'),(4,'00.280.273/0002-18','Samsung');