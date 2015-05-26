-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: proyectofinal_josegramage
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `dni` varchar(9) NOT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `direccion` varchar(99) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fnacimiento` varchar(50) DEFAULT NULL,
  `fechaalta` varchar(50) DEFAULT NULL,
  `login` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `estado` varchar(12) DEFAULT NULL,
  `tipo` varchar(9) DEFAULT NULL,
  `avatar` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('uno','uno','00000001R','111111111','111111111','adfaf@adfa.co','13/5/1986','17/4/2015','uno','81dc9bdb52d04dc20036dbd8313ed055','0','admin','src/proyectofinal_josegramage/Img/avatar_cliente/mObaBsyKWY.jpg'),('admin','admin','32577423Q','123456789','calle mayor 1','josegramage@gmail.com','25/5/1980','25/4/2015','admin','81dc9bdb52d04dc20036dbd8313ed055','inactivado','admin','src/proyectofinal_josegramage/Img/avatar_cliente/gHdeGdNbzN.jpg'),('cuatro','cuatro','48291735S','444444444','adfadsf','josegramage@gmail.com','17/5/1995','18/4/2015','cuatro','ff90603aa16bd65bc4e712115749be9b','0','admin','src/proyectofinal_josegramage/Img/avatar_cliente/icono_defecto.jpg'),('dos','dos','51826532B','222222222','222222222','josegramage@gmail.com','1/1/1980','16/4/2015','dos','81dc9bdb52d04dc20036dbd8313ed055','0','admin','src/proyectofinal_josegramage/Img/avatar_cliente/icono_defecto.jpg'),('tres','tres','57379364E','333333333','333333333','josegramage@gmail.com','14/5/1980','23/4/2015','tres','81dc9bdb52d04dc20036dbd8313ed055','inactivado','usuario',''),('uno','uno','68095492J','111111111','111111111','adfaf@adfa.co','13/5/1986','18/4/2015','uno','81dc9bdb52d04dc20036dbd8313ed055','0','admin','src/proyectofinal_josegramage/Img/avatar_cliente/kyljPESvzv.png');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'proyectofinal_josegramage'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-26  8:05:42
