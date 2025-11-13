-- SQL script for Navicat / MySQL to create database and tables used by the project
-- Run in Navicat Premium 17 (or any MySQL client)

CREATE DATABASE IF NOT EXISTS `coupon_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `coupon_db`;

DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `coupon`;

CREATE TABLE `coupon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(255) NOT NULL,
  `discount` DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  `exp_date` DATE DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_coupon_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT,
  `price` DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  `coupon_code` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_coupon_code` (`coupon_code`),
  CONSTRAINT `fk_product_coupon_code` FOREIGN KEY (`coupon_code`) REFERENCES `coupon` (`code`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Sample data
INSERT INTO `coupon` (`code`, `discount`, `exp_date`) VALUES ('Discount1111', 30.00, '2025-12-31');
INSERT INTO `product` (`name`, `description`, `price`, `coupon_code`) VALUES ('Widget A', 'Sample product A', 99.99, 'Discount1111');