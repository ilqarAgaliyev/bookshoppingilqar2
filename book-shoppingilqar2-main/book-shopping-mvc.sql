CREATE DATABASE  IF NOT EXISTS `book-shopping-mvc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `book-shopping-mvc`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: book-shopping-mvc-ajax
-- ------------------------------------------------------
-- Server version	5.5.37

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('u1','ROLE_ADMIN'),('u2','ROLE_ADMIN'),('u3','ROLE_ADMIN'),('u4','ROLE_ADMIN'),('u5','ROLE_ADMIN'),('u6','ROLE_ADMIN'),('u7','ROLE_ADMIN'),('u8','ROLE_ADMIN'),('u9','ROLE_ADMIN');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `basket_book`
--

DROP TABLE IF EXISTS `basket_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `basket_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `bookId` int(11) DEFAULT NULL,
  `orderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9rgkikwyg8n6dtoh58yjo4w92` (`bookId`),
  KEY `FKme8snq1it725oqbjkooh9ykjq` (`orderId`),
  CONSTRAINT `FKme8snq1it725oqbjkooh9ykjq` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK9rgkikwyg8n6dtoh58yjo4w92` FOREIGN KEY (`bookId`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basket_book`
--

LOCK TABLES `basket_book` WRITE;
/*!40000 ALTER TABLE `basket_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `basket_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `description` text,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `page_count` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=174 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (34,'Chad Darby','Head first Java proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla həm Java-nı, həmdə alqoritm qurmağı öyrənə bilərik.','fakeimage.png','Head first Java',724,343,'u1'),(35,'Max Darby','Head first CSS proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first CSS',456,23,'u1'),(36,'John Doe','Head first HTML proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first HTML',711,47,'u1'),(37,'James Gosling','Head first Bootstrap proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first Bootstrap',356,95,'u1'),(38,'Bill Gates','Head first JavaScript proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first JavaScript',2156,156,'u1'),(55,'James Gosling','Head first Spring proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first Spring',899,67,'u1'),(57,'John Doe','Head first Computer proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first Computer',456,44,'u1'),(58,'Bill Gates','Head first Swift proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first Swift',6567,67,'u1'),(59,'William Evelyn','Head first JSP proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first JSP',5643,56,'u1'),(60,'Ella Jackson','Head first Servlet proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first Servlet',1243,67,'u1'),(61,'William Jackson','Head first Sass proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first Sass',653,76,'u1'),(62,'John Doe','Head first AJAX proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first AJAX',764,98,'u1'),(63,'James Gosling','Head first Angular proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir. Biz bu kitabı oxumaqla dizayn qurmağı öyrənə bilərik.','fakeimage.png','Head first Angular',865,36,'u1'),(64,'Max Darby','Head first React proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first React',768,654,'u2'),(65,'Max Gosling','Head first Vue proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Vue',456,54,'u2'),(66,'John Gosling','Head first Math proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Math',633,43,'u2'),(67,'William Darby','Head first AOP proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first AOP',533,99,'u2'),(68,'Ella Jackson','Head first MySQL proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first MySQL',878,77,'u2'),(69,'Ella Gosling','Head first SQL proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first SQL',966,611,'u2'),(70,'Bill Gates','Head first MongoDB proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first MongoDB',3453,543,'u2'),(71,'Bill Jackson','Head first Oracle proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Oracle',5445,422,'u2'),(72,'Chad Darby','Head first Cloud proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Cloud',768,45,'u2'),(86,'Bill Gates','Head first Fat32 proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Fat32',518,34,'u2'),(87,'John Doe','Head first FileZilla proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first FileZilla',796,36,'u2'),(88,'Ella Jackson','Head first Firefox proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Firefox',659,43,'u2'),(89,'James Gosling','Head first Fortnite proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Fortnite',909,49,'u2'),(90,'John Doe','Head first Mozilla proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Mozilla',959,45,'u2'),(91,'James Gosling','Head first Google Sheets proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Google Sheets',828,48,'u3'),(92,'James Gosling','Head first Google Chrome proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Google Chrome',505,24,'u3'),(93,'William Jackson','Head first Google Docs proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Google Docs',643,24,'u3'),(94,'Bill Gates','Head first Google Slides proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Google Slides',586,44,'u3'),(95,'James Gosling','Head first Hitfilm proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Hitfilm',936,35,'u3'),(96,'James Gosling','Head first Internet Explorer proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Internet Explorer',619,21,'u3'),(97,'John Doe','Head first ImageShack proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first ImageShack',709,34,'u3'),(98,'Bill Gates','Head first iTunes proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first iTunes',528,39,'u3'),(99,'William Jackson','Head first Safari proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Safari',881,23,'u3'),(100,'John Doe','Head first IrfanView proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first IrfanView',893,43,'u3'),(101,'Max Darby','Head first Malwarebytes proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Malwarebytes',540,23,'u3'),(102,'Ella Jackson','Head first Microsoft Backup proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Microsoft Backup',845,42,'u3'),(103,'William Jackson','Head first Microsoft Combat proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Microsoft Combat',633,34,'u3'),(104,'James Gosling','Head first Microsoft Defrag proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Microsoft Defrag',677,21,'u3'),(105,'William Evelyn','Head first Microsoft OneNote proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Microsoft OneNote',992,48,'u4'),(106,'Ella Jackson','Head first Microsoft Paint proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Microsoft Paint',904,39,'u4'),(107,'Max Darby','Head first Microsoft Scandisk proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Microsoft Scandisk',600,36,'u4'),(108,'John Doe','Head first Microsoft Teams proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Microsoft Teams',695,49,'u4'),(109,'Bill Gates','Head first Media Player proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Media Player',834,34,'u4'),(110,'Bill Gates','Head first Netscape proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Netscape',873,21,'u4'),(111,'James Gosling','Head first Nocturne proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Nocturne',810,24,'u4'),(112,'Bill Gates','Head first Notepad proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Notepad',954,42,'u4'),(113,'Bill Gates','Head first Notepad++ proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Notepad++',673,22,'u4'),(114,'John Doe','Head first Obsidian proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Obsidian',760,20,'u4'),(115,'John Doe','Head first OpenOffice proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first OpenOffice',929,23,'u4'),(116,'William Jackson','Head first Opera proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Opera',583,41,'u4'),(117,'Bill Gates','Head first Opposing proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Opposing',704,47,'u5'),(118,'Chad Darby','Head first Partition Magic proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Partition Magic',955,27,'u5'),(119,'John Doe','Head first PicPick proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first PicPick',520,44,'u5'),(120,'Bill Gates','Head first PKZIP proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first PKZIP',973,47,'u5'),(121,'James Gosling','Head first Sacrifice proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Sacrifice',946,38,'u5'),(122,'John Doe','Head first Sanitarium proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Sanitarium',651,23,'u5'),(123,'William Evelyn','Head first Skype proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Skype',971,49,'u5'),(124,'James Gosling','Head first Telnet proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Telnet',758,21,'u5'),(125,'James Gosling','Head first Terminal proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Terminal',993,38,'u5'),(126,'Ella Jackson','Head first VirtualBox proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first VirtualBox',928,23,'u5'),(127,'Max Darby','Head first Visual Basic proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Visual Basic',711,49,'u5'),(128,'James Gosling','Head first Warcraft proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Warcraft',762,43,'u5'),(129,'Max Darby','Head first Winamp proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Winamp',773,44,'u5'),(130,'William Evelyn','Head first Movie Maker proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Movie Maker',996,48,'u5'),(131,'Bill Gates','Head first Windows Vista proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Windows Vista',990,44,'u6'),(132,'John Doe','Head first Xargon proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Xargon',691,43,'u6'),(133,'John Doe','Head first Zimbra proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Zimbra',581,30,'u6'),(134,'James Gosling','Head first Wolf proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Wolf',986,28,'u6'),(135,'William Evelyn','Head first Windows XP proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Windows XP',843,42,'u6'),(136,'Bill Gates','Head first Anydesk proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Anydesk',909,37,'u6'),(137,'Chad Darby','Head first Autocad proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Autocad',808,29,'u6'),(138,'Bill Gates','Head first Word proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Word',684,36,'u6'),(139,'John Doe','Head first Excel proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Excel',891,43,'u6'),(140,'William Jackson','Head first Access proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Access',552,20,'u6'),(141,'Max Darby','Head first Outlook proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Outlook',668,45,'u6'),(142,'John Doe','Head first PowerPoint proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first PowerPoint',575,46,'u6'),(143,'James Gosling','Head first Android proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Android',872,36,'u6'),(144,'Bill Gates','Head first IOS proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first IOS',659,31,'u6'),(145,'William Jackson','Head first Windows proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Windows',881,47,'u7'),(146,'Ella Jackson','Head first Linux proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Linux',931,23,'u7'),(147,'John Doe','Head first Mac proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Mac',660,24,'u7'),(148,'Ella Jackson','Head first Security proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Security',536,35,'u7'),(149,'William Jackson','Head first Abuse proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Abuse',729,42,'u7'),(150,'James Gosling','Head first After Effects proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first After Effects',586,23,'u7'),(151,'Chad Darby','Head first Audition proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Audition',611,24,'u7'),(152,'William Evelyn','Head first Bridge proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Bridge',905,33,'u7'),(153,'John Doe','Head first Creative Cloud proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Creative Cloud',847,24,'u7'),(154,'Ella Jackson','Head first Dreamweaver proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Dreamweaver',729,21,'u7'),(155,'Ella Jackson','Head first Illustrator proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Illustrator',849,47,'u7'),(156,'James Gosling','Head first InDesign proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first InDesign',798,43,'u7'),(157,'Ella Jackson','Head first Lightroom proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Lightroom',707,30,'u8'),(158,'James Gosling','Head first Pacific proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Pacific',877,30,'u8'),(159,'Bill Gates','Head first Europe proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Europe',667,28,'u8'),(160,'William Jackson','Head first Bungie proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Bungie',708,23,'u8'),(161,'Bill Gates','Head first Photoshop proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Photoshop',708,30,'u8'),(162,'John Doe','Head first Premiere Pro proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Premiere Pro',563,28,'u8'),(163,'John Doe','Head first Premiere Rush proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Premiere Rush',757,27,'u8'),(164,'Bill Gates','Head first Amazon Silk proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Amazon Silk',585,44,'u9'),(165,'James Gosling','Head first AOL proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first AOL',587,28,'u9'),(166,'John Doe','Head first Maven proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Maven',528,48,'u9'),(167,'William Evelyn','Head first Gradle proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Gradle',770,39,'u9'),(168,'Chad Darby','Head first Python proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Python',950,25,'u9'),(169,'James Gosling','Head first Scratch proqramlaşdırmanı öyrənmək üçün çox yaxşı seçimdir','fakeimage.png','Head first Scratch',742,44,'u9');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `note` varchar(255) DEFAULT NULL,
  `register` datetime DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK624gtjin3po807j3vix093tlf` (`customerId`),
  CONSTRAINT `FK624gtjin3po807j3vix093tlf` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('u1','p1',1),('u2','p2',1),('u3','p3',1),('u4','p4',1),('u5','p5',1),('u6','p6',1),('u7','p7',1),('u8','p8',1),('u9','p9',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-10 22:14:33
