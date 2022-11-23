-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eczaneotomasyon
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `hasta`
--

DROP TABLE IF EXISTS `hasta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hasta` (
  `HastaTc` varchar(45) NOT NULL,
  `İsim` varchar(45) DEFAULT NULL,
  `Soyisim` varchar(45) DEFAULT NULL,
  `IlceID` varchar(45) DEFAULT NULL,
  `SigortaTuru` varchar(45) DEFAULT NULL,
  `DogumTarihi` date DEFAULT NULL,
  `ID` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`HastaTc`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hasta`
--

LOCK TABLES `hasta` WRITE;
/*!40000 ALTER TABLE `hasta` DISABLE KEYS */;
INSERT INTO `hasta` VALUES ('11234567','Ufuk','Kerim',NULL,'SGK','2001-10-10',1),('11234568','Uğur','Özcan',NULL,'BAĞKUR','2000-08-02',2),('11234569','Ahmet','Filiz',NULL,'YOK','1992-01-04',3),('12234567','Mehmet','Uluyurt',NULL,'YOK','1975-04-02',4),('12234568','Dilara','Yeşilyurt',NULL,'SGK','2001-05-24',5),('12234569','Furkan','İsmailoğlu',NULL,'SGK','1965-04-07',6),('13234567','Fatih','Tadık',NULL,'SGK','1962-05-07',7),('13234568','Emre','Ertek',NULL,'BAĞKUR','2001-03-05',8),('13234569','Berkant','Büber',NULL,'YOK','2000-04-02',9),('14234567','Eren','Yılmaz',NULL,'YOK','1985-01-08',10),('14234568','Miraç','Kırbıyık',NULL,'SGK','1993-11-27',11),('14234569','Filiz','Duman',NULL,'BAĞKUR','1946-12-30',12),('15234567','Berk','Kantar',NULL,'SGK','1976-10-12',13),('15234568','Kamil','Pala',NULL,'SGK','2015-09-04',14);
/*!40000 ALTER TABLE `hasta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-16 23:48:32
