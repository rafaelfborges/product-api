CREATE TABLE `venda` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_compra` date NOT NULL,
  `total_compra` decimal(19,2) DEFAULT NULL,
  `cliente_id` bigint(20) NOT NULL,
  `fornecedor_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK50murhuotq9h2dnxej317jjiy` (`cliente_id`),
  KEY `FK29grb6hh30perue3v1btueq6d` (`fornecedor_id`),
  CONSTRAINT `FK29grb6hh30perue3v1btueq6d` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id`),
  CONSTRAINT `FK50murhuotq9h2dnxej317jjiy` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `venda_produtos` (
  `venda_id` bigint(20) NOT NULL,
  `produtos_id` bigint(20) NOT NULL,
  PRIMARY KEY (`venda_id`,`produtos_id`),
  UNIQUE KEY `UK_skdxfwlcsg1cxw7eddnkidf5g` (`produtos_id`),
  CONSTRAINT `FK66sx48snxj3x5us4avomrfkli` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`),
  CONSTRAINT `FKaf1qmopp34f98prurcav28w7i` FOREIGN KEY (`produtos_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;