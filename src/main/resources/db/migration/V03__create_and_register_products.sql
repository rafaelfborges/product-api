CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `promotion` bit(1) NOT NULL,
  `quantity` bigint NOT NULL,
  `value` decimal(19,2) NOT NULL,
  `promotion_value` decimal(19,2) DEFAULT NULL,
  `supplier_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo6c1dbi17sempey5dpnx6ovrj` (`supplier_id`),
  CONSTRAINT `FKo6c1dbi17sempey5dpnx6ovrj` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `products` VALUES (1,'Eletrônicos','#1001','notebook.jpg','Notebook Positivo',_binary '\0',10,1500.00,0.00,1),(2,'Eletrônicos','#1002','notebook.jpg','Notebook Acer Nitro 5',_binary '\0',5,7500.00,0.00,1),(3,'Eletrônicos','#1003','notebook.jpg','Notebook Samsung',_binary '',0,3500.00,39.99,1),(4,'Eletrônicos','#1001','tv.jpg','TV Samsung 50 Polegadas',_binary '\0',5,5500.00,0.00,2),(5,'Eletrônicos','#1002','tv.jpg','TV LG 42 Polegadas',_binary '',7,2500.00,99.99,2),(6,'Eletrônicos','#1003','tv.jpg','TV LG 60 Polegadas',_binary '',0,7500.00,299.90,2),(7,'Smartphones','#1001','iphone.jpg','iPhone 12',_binary '\0',100,13999.99,0.00,3),(8,'Eletrônicos','#1002','macbookpro.jpg','Macbook Pro M1',_binary '\0',50,24999.99,0.00,3),(9,'Smartwatchs','#1003','applewatch.jpg','Apple Watch',_binary '',0,8999.99,399.99,3),(10,'Smartphones','#2001','samsungs20.jpg','Samsung S20 Plus',_binary '',10,3500.00,99.99,4),(11,'Smartphones','#2002','samsungs20.jpg','Samsung S20',_binary '',5,2999.00,99.99,4),(12,'Smartwatchs','#2003','smartwatchactive2.jpg','Galaxy Watch Active2',_binary '\0',0,1999.00,0.00,4);