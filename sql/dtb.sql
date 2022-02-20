CREATE DATABASE  IF NOT EXISTS `subject_manager` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `subject_manager`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: subject_manager
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `period`
--

DROP TABLE IF EXISTS `period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `period` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_active` tinyint(1) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `is_represent` tinyint(1) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `max_allow` int DEFAULT '3',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `period`
--

LOCK TABLES `period` WRITE;
/*!40000 ALTER TABLE `period` DISABLE KEYS */;
INSERT INTO `period` VALUES (1,0,'2019-10-02 08:00:00','2019-10-08 12:00:00',0,'20201',3),(2,0,'2020-02-03 09:00:00','2020-02-09 18:00:00',0,'20202',3),(3,0,'2020-09-15 10:00:00','2020-09-25 14:00:00',0,'20211',3),(4,1,'2021-03-03 07:00:00','2021-03-10 15:00:00',1,'20212',3);
/*!40000 ALTER TABLE `period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `serial` varchar(45) DEFAULT NULL,
  `is_require_attach_class` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serial_UNIQUE` (`serial`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Công nghệ Nano','ET4600',0),(2,'Điện tử công suất	','ET4610',0),(3,'Lập trình Java	','IT3650',0),(4,'Thông tin vô tuyến	','ET3180',1),(5,'Hệ thống viễn thông','ET4250',1),(6,'Thực tập cuối khóa','ET5011',0),(7,'Xử lý tín hiệu số','ET4020',1),(8,'Phân tích và thiết kế hướng đối tượng','ET4060',0);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` char(80) NOT NULL,
  `is_staff` tinyint(1) DEFAULT '0',
  `fullname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `class` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'20164406','$2a$10$/nf9YpRAuHzpVElXk1J6GeUuQJblYk1hEdoTnMpyoN.lqd2R7VXrW',0,'Pham Quang Tuan','tuanquang123321@email.com','01234567991','KT ĐTTT 06 - K61'),(2,'giaovu','$2a$10$/nf9YpRAuHzpVElXk1J6GeUuQJblYk1hEdoTnMpyoN.lqd2R7VXrW',1,'Nguyen Thi A','nguyenthia@gmail.com','0123123123',NULL),(3,'20176652','$2a$10$/nf9YpRAuHzpVElXk1J6GeUuQJblYk1hEdoTnMpyoN.lqd2R7VXrW',0,'Nguyen Anh Minh','nguyenanhminh@gmail.com','0123456789','TTĐTVT02 - K62');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_subject`
--

DROP TABLE IF EXISTS `user_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `subject_id` int NOT NULL,
  `class_id` varchar(20) NOT NULL,
  `attach_class_id` varchar(45) DEFAULT NULL,
  `period_id` int NOT NULL,
  `is_complete` tinyint(1) DEFAULT '0',
  `reply_message` varchar(100) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `period_id_idx` (`period_id`),
  KEY `subject_id_subject_idx` (`subject_id`),
  KEY `user_id_subject_idx` (`user_id`),
  CONSTRAINT `period_id_subject` FOREIGN KEY (`period_id`) REFERENCES `period` (`id`),
  CONSTRAINT `subject_id_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `user_id_subject` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_subject`
--

LOCK TABLES `user_subject` WRITE;
/*!40000 ALTER TABLE `user_subject` DISABLE KEYS */;
INSERT INTO `user_subject` VALUES (1,3,1,'781562',NULL,4,1,'null','2022-02-02 01:42:00','2022-02-20 15:29:35'),(2,3,2,'781555',NULL,4,1,'null','2022-02-02 01:45:00','2022-02-20 17:22:02'),(3,1,4,'741556','745126',4,0,'Sai mã học phần','2022-02-02 02:45:00','2022-02-20 17:49:03'),(4,1,3,'741333','',4,1,'','2022-02-02 02:46:00','2022-02-20 15:05:50'),(5,1,5,'514598',NULL,4,0,NULL,'2022-02-02 02:00:00',NULL),(6,1,5,'514589',NULL,3,0,NULL,'2021-06-06 06:00:00',NULL),(7,1,7,'123123','123124',4,0,NULL,'2022-02-20 16:59:41',NULL);
/*!40000 ALTER TABLE `user_subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-20 18:21:35
