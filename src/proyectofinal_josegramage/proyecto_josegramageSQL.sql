CREATE DATABASE  IF NOT EXISTS `proyectofinal_josegramage` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `proyectofinal_josegramage`;
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
  `fnacimiento` varchar(50) DEFAULT '"00/00/0000"',
  `fechaalta` varchar(50) DEFAULT '"00/00/0000"',
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
INSERT INTO `clientes` VALUES ('cinco','cinco','06557871L','555555555','calle','josegramage@gmail.com','15/5/1986','26/4/2015','cinco','81dc9bdb52d04dc20036dbd8313ed055','inactivado','usuario','src/proyectofinal_josegramage/Img/avatar_cliente/KrBhhqKjhO.jpg'),('uno','uno','25056466J','111111111','111111111111','josegramage@gmail.com','1/1/1980','26/4/2015','uno','81dc9bdb52d04dc20036dbd8313ed055','inactivado','admin','src/proyectofinal_josegramage/Img/avatar_cliente/JLWueXaYoe.jpg'),('cuatro','cuatro','48291735S','444444444','adfadsf','josegramage@gmail.com','17/5/1995','18/4/2015','cuatro','81dc9bdb52d04dc20036dbd8313ed055','inactivado','admin','src/proyectofinal_josegramage/Img/avatar_cliente/aBBksGLAPL.jpg'),('dos','dos','51826532B','222222222','222222222','josegramage@gmail.com','1/1/1980','16/4/2015','dos','81dc9bdb52d04dc20036dbd8313ed055','inactivado','admin','src/proyectofinal_josegramage/Img/avatar_cliente/ZvOVobBIyW.jpg'),('usuario','usuario','59065775G','121212121','calle la que sea','josegramage@gmail.com','15/5/1987','26/4/2015','usuario','81dc9bdb52d04dc20036dbd8313ed055','inactivado','usuario',''),('cuatro','cuatro','83861514H','444444444','adfadsf','josegramage@gmail.com','17/5/1995','26/4/2015','cuatro','81dc9bdb52d04dc20036dbd8313ed055','inactivado','admin','src/proyectofinal_josegramage/Img/avatar_cliente/aBBksGLAPL.jpg');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_registro_crear_clientes` AFTER INSERT ON `clientes` FOR EACH
ROW BEGIN
insert into registro_crear_clientes(fecha_crear, dni, nombre, apellidos, login, tipo)
values( Now(), new.dni, new.nombre, new.apellidos, new.login, new.tipo);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_registro_modif_clientes` AFTER UPDATE ON `clientes` FOR EACH
ROW BEGIN
insert into registro_modif_clientes(fecha_modif, dni, nombre, apellidos, login, tipo)
values( Now(), new.dni, new.nombre, new.apellidos, new.login, new.tipo);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_registro_elim_clientes` AFTER DELETE ON `clientes` FOR EACH
ROW BEGIN
insert into registro_elim_clientes(fecha_elim, dni, nombre, apellidos, login, tipo)
values( Now(), old.dni, old.nombre, old.apellidos, old.login, old.tipo);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `juegos`
--

DROP TABLE IF EXISTS `juegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `juegos` (
  `ref` varchar(9) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `companyia` varchar(50) DEFAULT NULL,
  `fecha_alta` varchar(50) DEFAULT '"00/00/0000"',
  `tipo` varchar(50) DEFAULT NULL,
  `precio` varchar(7) DEFAULT NULL,
  `imagen` varchar(150) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ref`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juegos`
--

LOCK TABLES `juegos` WRITE;
/*!40000 ALTER TABLE `juegos` DISABLE KEYS */;
INSERT INTO `juegos` VALUES ('adfa','adsf','adfa','28/4/2015','adf','33','',''),('adfadf','prueb','prueba','28/4/2015','prueba','13','','adsfadf'),('J001','Guerra Zombie','VillaDaw','01/01/2015','accion','30','','acaba con los zombies antes de que ellos acaben contigo');
/*!40000 ALTER TABLE `juegos` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_registro_crear_juegos` AFTER INSERT ON `juegos` FOR EACH
ROW BEGIN
insert into registro_crear_clientes(fecha_crear, ref, nombre, companyia)
values( Now(), new.ref, new.nombre, new.companyia);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_registro_modif_juegos` AFTER UPDATE ON `juegos` FOR EACH
ROW BEGIN
insert into registro_modif_clientes(fecha_modif, ref, nombre, companyia)
values( Now(), new.ref, new.nombre, new.companyia);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_registro_elim_juegos` AFTER DELETE ON `juegos` FOR EACH
ROW BEGIN
insert into registro_elim_clientes(fecha_elim, ref, nombre, companyia)
values( Now(), old.ref, old.nombre, old.companyia);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `registro_crear_clientes`
--

DROP TABLE IF EXISTS `registro_crear_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_crear_clientes` (
  `fecha_crear` datetime NOT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `login` varchar(40) DEFAULT NULL,
  `tipo` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_crear_clientes`
--

LOCK TABLES `registro_crear_clientes` WRITE;
/*!40000 ALTER TABLE `registro_crear_clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_crear_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_crear_juegos`
--

DROP TABLE IF EXISTS `registro_crear_juegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_crear_juegos` (
  `fecha_creacion` datetime NOT NULL,
  `ref` varchar(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `companyia` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_crear_juegos`
--

LOCK TABLES `registro_crear_juegos` WRITE;
/*!40000 ALTER TABLE `registro_crear_juegos` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_crear_juegos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_elim_clientes`
--

DROP TABLE IF EXISTS `registro_elim_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_elim_clientes` (
  `fecha_eliminacion` datetime NOT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `login` varchar(40) DEFAULT NULL,
  `tipo` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_elim_clientes`
--

LOCK TABLES `registro_elim_clientes` WRITE;
/*!40000 ALTER TABLE `registro_elim_clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_elim_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_elim_juegos`
--

DROP TABLE IF EXISTS `registro_elim_juegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_elim_juegos` (
  `fecha_elim` datetime NOT NULL,
  `ref` varchar(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `companyia` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_elim_juegos`
--

LOCK TABLES `registro_elim_juegos` WRITE;
/*!40000 ALTER TABLE `registro_elim_juegos` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_elim_juegos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_modif_clientes`
--

DROP TABLE IF EXISTS `registro_modif_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_modif_clientes` (
  `fecha_modif` datetime NOT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `login` varchar(40) DEFAULT NULL,
  `tipo` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_modif_clientes`
--

LOCK TABLES `registro_modif_clientes` WRITE;
/*!40000 ALTER TABLE `registro_modif_clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_modif_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_modif_juegos`
--

DROP TABLE IF EXISTS `registro_modif_juegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_modif_juegos` (
  `fecha_modif` datetime NOT NULL,
  `ref` varchar(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `companyia` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_modif_juegos`
--

LOCK TABLES `registro_modif_juegos` WRITE;
/*!40000 ALTER TABLE `registro_modif_juegos` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_modif_juegos` ENABLE KEYS */;
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

-- Dump completed on 2015-05-29  7:53:59
