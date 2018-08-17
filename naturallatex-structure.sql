-- MySQL dump 10.13  Distrib 5.7.17, for FreeBSD11.0 (amd64)
--
-- Host: localhost    Database: morfeusflex
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `billing_address`
--

DROP TABLE IF EXISTS `billing_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billing_address` (
  `billing_address_id` int(11) NOT NULL,
  `first_name` varchar(60) DEFAULT '',
  `last_name` varchar(60) DEFAULT '',
  `company` varchar(256) DEFAULT '',
  `address` varchar(256) DEFAULT '',
  `city` varchar(60) DEFAULT '',
  `state` varchar(56) DEFAULT '',
  `postcode` varchar(56) DEFAULT '',
  `country` varchar(56) DEFAULT '',
  `phone` varchar(56) DEFAULT '',
  `fax` varchar(56) DEFAULT '',
  `default_address` tinyint(1) DEFAULT '0',
  `cust_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`billing_address_id`),
  KEY `cust_id` (`cust_id`),
  CONSTRAINT `billing_address_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contact_us`
--

DROP TABLE IF EXISTS `contact_us`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_us` (
  `contact_id` int(11) NOT NULL,
  `subject` varchar(65) DEFAULT '',
  `message` text,
  `email_address` varchar(256) DEFAULT '',
  `phone_number` varchar(65) DEFAULT '',
  `first_name` varchar(65) DEFAULT '',
  `last_name` varchar(65) DEFAULT '',
  `cust_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  KEY `cust_id` (`cust_id`),
  CONSTRAINT `contact_us_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `cust_id` int(11) NOT NULL,
  `first_name` varchar(60) DEFAULT '',
  `last_name` varchar(60) DEFAULT '',
  `password` varchar(256) DEFAULT '',
  `email_address` varchar(125) DEFAULT '',
  `phone` varchar(60) DEFAULT '',
  `fax` varchar(56) DEFAULT '',
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer_registration`
--

DROP TABLE IF EXISTS `customer_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_registration` (
  `reg_id` int(11) NOT NULL,
  `cust_id` int(11) NOT NULL,
  `reg_date` date DEFAULT NULL,
  `cancel_date` date DEFAULT NULL,
  PRIMARY KEY (`reg_id`),
  KEY `cust_id` (`cust_id`),
  CONSTRAINT `customer_registration_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_line`
--

DROP TABLE IF EXISTS `order_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_line` (
  `order_line_number` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `qty` int(11) DEFAULT '0',
  PRIMARY KEY (`order_line_number`),
  UNIQUE KEY `order_product_keys` (`order_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `order_line_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `purchase_order` (`order_id`),
  CONSTRAINT `order_line_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payment_detail`
--

DROP TABLE IF EXISTS `payment_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_detail` (
  `payment_detail_id` int(11) NOT NULL,
  `card_type` varchar(20) DEFAULT '',
  `card_number` varchar(56) DEFAULT '',
  `exp_date` date DEFAULT NULL,
  `card_verification_code` varchar(10) DEFAULT '',
  `card_holder_name` varchar(56) DEFAULT '',
  `paypal_email` varchar(256) DEFAULT '',
  `cust_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`payment_detail_id`),
  KEY `cust_id` (`cust_id`),
  CONSTRAINT `payment_detail_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pre_order`
--

DROP TABLE IF EXISTS `pre_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pre_order` (
  `order_number` int(11) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `cust_id` int(11) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `order_date` date DEFAULT NULL,
  `notes` text,
  PRIMARY KEY (`order_number`),
  KEY `FKA779D6B291FA8268` (`cust_id`),
  KEY `FKA779D6B2A9FF2EF7` (`product_id`),
  CONSTRAINT `FKA779D6B291FA8268` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`),
  CONSTRAINT `FKA779D6B2A9FF2EF7` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_code` varchar(20) DEFAULT '',
  `product_name` varchar(64) NOT NULL,
  `product_desc` text,
  `unit_price` double DEFAULT '9999.99',
  `qty` int(11) DEFAULT '0',
  `bed_size` varchar(30) DEFAULT NULL,
  `firmness_rating` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `product_code` (`product_code`),
  KEY `product_name` (`product_name`),
  KEY `unit_price` (`unit_price`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `cust_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `order_date` date DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `payment_detail_id` int(11) DEFAULT NULL,
  `shipping_address_id` int(11) DEFAULT NULL,
  `billing_address_id` int(11) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `transit_insurance_fee` double DEFAULT '0',
  `shipping_notes` varchar(125) DEFAULT NULL,
  `qty` int(11) DEFAULT '0',
  `shipping_date` date DEFAULT NULL,
  `order_line_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_date` (`order_date`),
  KEY `cust_id` (`cust_id`),
  KEY `order_line_number` (`order_line_number`),
  CONSTRAINT `purchase_order_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipping_address`
--

DROP TABLE IF EXISTS `shipping_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipping_address` (
  `shipping_address_id` int(11) NOT NULL,
  `first_name` varchar(60) DEFAULT '',
  `last_name` varchar(60) DEFAULT '',
  `company` varchar(256) DEFAULT '',
  `address` varchar(256) DEFAULT '',
  `city` varchar(60) DEFAULT '',
  `state` varchar(56) DEFAULT '',
  `postcode` varchar(56) DEFAULT '',
  `country` varchar(56) DEFAULT '',
  `phone` varchar(56) DEFAULT '',
  `fax` varchar(56) DEFAULT '',
  `default_address` tinyint(1) DEFAULT '0',
  `cust_id` int(11) NOT NULL,
  PRIMARY KEY (`shipping_address_id`),
  KEY `cust_id` (`cust_id`),
  CONSTRAINT `shipping_address_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipping_detail`
--

DROP TABLE IF EXISTS `shipping_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipping_detail` (
  `shipping_detail_id` int(11) NOT NULL,
  `order_line_number` int(11) NOT NULL,
  `shipper_name` varchar(125) DEFAULT NULL,
  `qty` int(11) DEFAULT '0',
  `shipping_date` date DEFAULT NULL,
  `consignment_number` varchar(255) DEFAULT NULL,
  `delivery_status` int(11) DEFAULT NULL,
  `sender_comment` text,
  `receiver_comment` text,
  `shipper_comment` text,
  `departing_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shipping_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-01  5:01:27
