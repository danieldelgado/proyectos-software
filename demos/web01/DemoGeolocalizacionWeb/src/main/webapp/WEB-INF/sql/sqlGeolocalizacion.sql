CREATE DATABASE  IF NOT EXISTS `geolocalizacion` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `geolocalizacion`;
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: geolocalizacion
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2

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
-- Table structure for table `geolocalizacion`
--

DROP TABLE IF EXISTS `geolocalizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geolocalizacion` (
  `id_geolocalizacion` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_registro` datetime DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_geolocalizacion`),
  KEY `FK7E2A2A1B876B6E10` (`id_usuario`),
  CONSTRAINT `FK7E2A2A1B876B6E10` FOREIGN KEY (`id_usuario`) REFERENCES `telefono` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geolocalizacion`
--

LOCK TABLES `geolocalizacion` WRITE;
/*!40000 ALTER TABLE `geolocalizacion` DISABLE KEYS */;
INSERT INTO `geolocalizacion` VALUES (1,'2013-05-21 14:09:52',1),(2,'2013-05-21 14:10:07',1);
/*!40000 ALTER TABLE `geolocalizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `punto_geolocalizacion`
--

DROP TABLE IF EXISTS `punto_geolocalizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `punto_geolocalizacion` (
  `id_punto` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_registro` datetime DEFAULT NULL,
  `flagPuntoInicial` bit(1) DEFAULT NULL,
  `latitud` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `longitud` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `geolocalizacion_id_geolocalizacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_punto`),
  KEY `FKFE259B20B06B3A64` (`geolocalizacion_id_geolocalizacion`),
  CONSTRAINT `FKFE259B20B06B3A64` FOREIGN KEY (`geolocalizacion_id_geolocalizacion`) REFERENCES `geolocalizacion` (`id_geolocalizacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `punto_geolocalizacion`
--

LOCK TABLES `punto_geolocalizacion` WRITE;
/*!40000 ALTER TABLE `punto_geolocalizacion` DISABLE KEYS */;
INSERT INTO `punto_geolocalizacion` VALUES (1,'2013-05-21 14:09:52','','-12.54684','-70.646848',1),(2,'2013-05-21 14:09:56','\0','-12.54684','-70.646848',1),(3,'2013-05-21 14:10:03','\0','-12.546841','-70.64684865',1),(4,'2013-05-21 14:10:07','','-12.546841','-70.64684865',2);
/*!40000 ALTER TABLE `punto_geolocalizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono` (
  `numero` varchar(12) COLLATE latin1_spanish_ci NOT NULL,
  `tipo_telefono` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FKAEE86AF48AD67DE6` (`id_usuario`),
  CONSTRAINT `FKAEE86AF48AD67DE6` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono`
--

LOCK TABLES `telefono` WRITE;
/*!40000 ALTER TABLE `telefono` DISABLE KEYS */;
INSERT INTO `telefono` VALUES ('987654321',1,1);
/*!40000 ALTER TABLE `telefono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `apellidos_completos` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `nombres_completo` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'asdsad asd','2013-05-21',NULL,'2013-05-21 14:08:54','asd asdsad');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-21 15:58:41
