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
-- Temporary view structure for view `ilaclar_stok`
--

DROP TABLE IF EXISTS `ilaclar_stok`;
/*!50001 DROP VIEW IF EXISTS `ilaclar_stok`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `ilaclar_stok` AS SELECT 
 1 AS `Barkod`,
 1 AS `Urunadi`,
 1 AS `Etkinmadde`,
 1 AS `Kullanimyasi`,
 1 AS `Ilacturu`,
 1 AS `Fiyat`,
 1 AS `IlacAdet`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `ilaclar_recete`
--

DROP TABLE IF EXISTS `ilaclar_recete`;
/*!50001 DROP VIEW IF EXISTS `ilaclar_recete`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `ilaclar_recete` AS SELECT 
 1 AS `Barkod`,
 1 AS `Urunadi`,
 1 AS `Etkinmadde`,
 1 AS `Kullanimyasi`,
 1 AS `Ilacturu`,
 1 AS `HastaTc`,
 1 AS `ReceteID`,
 1 AS `Fiyat`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `ilaclar_stok`
--

/*!50001 DROP VIEW IF EXISTS `ilaclar_stok`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ilaclar_stok` AS select `ilaclar`.`Barkod` AS `Barkod`,`ilaclar`.`Urunadi` AS `Urunadi`,`ilaclar`.`Etkinmadde` AS `Etkinmadde`,`ilaclar`.`Kullanimyasi` AS `Kullanimyasi`,`ilaclar`.`Ilacturu` AS `Ilacturu`,`ilaclar`.`Fiyat` AS `Fiyat`,`stogagelenilaclar`.`IlacAdet` AS `IlacAdet` from (`ilaclar` join `stogagelenilaclar` on((`ilaclar`.`Urunadi` = `stogagelenilaclar`.`Urunadi`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ilaclar_recete`
--

/*!50001 DROP VIEW IF EXISTS `ilaclar_recete`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ilaclar_recete` AS select `recete`.`Barkod` AS `Barkod`,`recete`.`Urunadi` AS `Urunadi`,`recete`.`Etkinmadde` AS `Etkinmadde`,`recete`.`Kullanimyasi` AS `Kullanimyasi`,`recete`.`Ilacturu` AS `Ilacturu`,`recete`.`HastaTc` AS `HastaTc`,`recete`.`ReceteID` AS `ReceteID`,`ilaclar`.`Fiyat` AS `Fiyat` from (`recete` join `ilaclar` on((`recete`.`Urunadi` = `ilaclar`.`Urunadi`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-16 23:48:32
