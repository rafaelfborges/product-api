CREATE TABLE `vendas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_compra` date NOT NULL,
  `total_compra` decimal(19,2) DEFAULT NULL,
  `cliente_id` bigint NOT NULL,
  `fornecedor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK50murhuotq9h2dnxej317jjiy` (`cliente_id`),
  KEY `FK29grb6hh30perue3v1btueq6d` (`fornecedor_id`),
  CONSTRAINT `FK29grb6hh30perue3v1btueq6d` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedores` (`id`),
  CONSTRAINT `FK50murhuotq9h2dnxej317jjiy` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `venda_produto` (
  `venda_id` bigint NOT NULL,
  `produtos_id` bigint NOT NULL,
  PRIMARY KEY (`venda_id`,`produtos_id`),
  KEY `UK_skdxfwlcsg1cxw7eddnkidf5g` (`produtos_id`),
  CONSTRAINT `FK66sx48snxj3x5us4avomrfkli` FOREIGN KEY (`venda_id`) REFERENCES `vendas` (`id`),
  CONSTRAINT `FKaf1qmopp34f98prurcav28w7i` FOREIGN KEY (`produtos_id`) REFERENCES `produtos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;