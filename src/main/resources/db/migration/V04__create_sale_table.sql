CREATE TABLE `sales` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_sale` date NOT NULL,
  `total_sale` decimal(19,2) DEFAULT NULL,
  `client_id` bigint NOT NULL,
  `supplier_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK50murhuotq9h2dnxej317jjiy` (`client_id`),
  KEY `FK29grb6hh30perue3v1btueq6d` (`supplier_id`),
  CONSTRAINT `FK29grb6hh30perue3v1btueq6d` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`),
  CONSTRAINT `FK50murhuotq9h2dnxej317jjiy` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sales_products` (
  `sale_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`sale_id`,`product_id`),
  KEY `UK_skdxfwlcsg1cxw7eddnkidf5g` (`product_id`),
  CONSTRAINT `FK66sx48snxj3x5us4avomrfkli` FOREIGN KEY (`sale_id`) REFERENCES `sales` (`id`),
  CONSTRAINT `FKaf1qmopp34f98prurcav28w7i` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;