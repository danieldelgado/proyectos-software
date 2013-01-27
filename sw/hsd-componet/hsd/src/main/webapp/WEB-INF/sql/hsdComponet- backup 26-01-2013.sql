CREATE DATABASE  IF NOT EXISTS `hsd` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hsd`;
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: hsd
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.1

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
-- Table structure for table `boton`
--

DROP TABLE IF EXISTS `boton`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boton` (
  `bloqueable` bit(1) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `icono` varchar(50) DEFAULT NULL,
  `on_complete` varchar(80) DEFAULT NULL,
  `on_submit` varchar(80) DEFAULT NULL,
  `orden` int(11) NOT NULL,
  `parametros_json` longtext,
  `tipo` varchar(50) NOT NULL,
  `url` varchar(250) DEFAULT NULL,
  `id_recurso` int(11) NOT NULL,
  `on_click` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_recurso`),
  KEY `FK59935E69D62F729` (`id_recurso`),
  CONSTRAINT `FK59935E69D62F729` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boton`
--

LOCK TABLES `boton` WRITE;
/*!40000 ALTER TABLE `boton` DISABLE KEYS */;
/*!40000 ALTER TABLE `boton` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boton_por_menu`
--

DROP TABLE IF EXISTS `boton_por_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boton_por_menu` (
  `id_menu` int(11) NOT NULL,
  `id_boton` int(11) NOT NULL,
  KEY `FK14A0D6049ACF6823` (`id_boton`),
  KEY `FK14A0D604579CC787` (`id_menu`),
  CONSTRAINT `FK14A0D604579CC787` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_recurso`),
  CONSTRAINT `FK14A0D6049ACF6823` FOREIGN KEY (`id_boton`) REFERENCES `boton` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boton_por_menu`
--

LOCK TABLES `boton_por_menu` WRITE;
/*!40000 ALTER TABLE `boton_por_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `boton_por_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `codigo` varchar(50) NOT NULL,
  `estado_civil` int(11) NOT NULL,
  `numero_documento` varchar(12) NOT NULL,
  `ruc` varchar(11) NOT NULL,
  `tipo_documento` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `FK334B85FACB6EE1EF` (`id_persona`),
  CONSTRAINT `FK334B85FACB6EE1EF` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codigo_cliente`
--

DROP TABLE IF EXISTS `codigo_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codigo_cliente` (
  `codigo` varchar(50) NOT NULL,
  `id_persona` int(11) NOT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `FK29DA8654272A983D` (`id_persona`),
  CONSTRAINT `FK29DA8654272A983D` FOREIGN KEY (`id_persona`) REFERENCES `cliente` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigo_cliente`
--

LOCK TABLES `codigo_cliente` WRITE;
/*!40000 ALTER TABLE `codigo_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `codigo_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codigo_usuario`
--

DROP TABLE IF EXISTS `codigo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codigo_usuario` (
  `codigo` varchar(50) NOT NULL,
  `id_persona` int(11) NOT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `FKEEA3F388EBF40571` (`id_persona`),
  CONSTRAINT `FKEEA3F388EBF40571` FOREIGN KEY (`id_persona`) REFERENCES `usuario` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigo_usuario`
--

LOCK TABLES `codigo_usuario` WRITE;
/*!40000 ALTER TABLE `codigo_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `codigo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `columna`
--

DROP TABLE IF EXISTS `columna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `columna` (
  `id_columna` int(11) NOT NULL,
  `activo` bit(1) NOT NULL,
  `addColumn` bit(1) NOT NULL,
  `alineacion` varchar(50) NOT NULL,
  `ancho` int(11) NOT NULL,
  `atributo` varchar(50) NOT NULL,
  `cabecera` varchar(50) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `estado` char(1) NOT NULL,
  `fecha_actualizacion` date NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `formato_tipo` varchar(50) NOT NULL,
  `mapping` bit(1) NOT NULL,
  `orden` int(11) NOT NULL,
  `tabla` varchar(50) NOT NULL,
  `visible` bit(1) NOT NULL,
  PRIMARY KEY (`id_columna`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `columna`
--

LOCK TABLES `columna` WRITE;
/*!40000 ALTER TABLE `columna` DISABLE KEYS */;
INSERT INTO `columna` VALUES (1,'','','rigth',100,'id','id','idqdqwd','A','1990-10-10','1990-10-10 00:00:00','','',0,'',''),(2,'','','rigth',100,'nombre','nombre','nombreqdqwd','A','1990-10-10','1990-10-10 00:00:00','','',0,'',''),(3,'','','rigth',100,'valor','valor','valorqdqwd','A','1990-10-10','1990-10-10 00:00:00','','',0,'','');
/*!40000 ALTER TABLE `columna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `columna_por_lista`
--

DROP TABLE IF EXISTS `columna_por_lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `columna_por_lista` (
  `lista_id_recurso` int(11) NOT NULL,
  `columna_id_columna` int(11) NOT NULL,
  KEY `FK303EBF239952F321` (`columna_id_columna`),
  KEY `FK303EBF235204655F` (`lista_id_recurso`),
  CONSTRAINT `FK303EBF235204655F` FOREIGN KEY (`lista_id_recurso`) REFERENCES `lista` (`id_recurso`),
  CONSTRAINT `FK303EBF239952F321` FOREIGN KEY (`columna_id_columna`) REFERENCES `columna` (`id_columna`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `columna_por_lista`
--

LOCK TABLES `columna_por_lista` WRITE;
/*!40000 ALTER TABLE `columna_por_lista` DISABLE KEYS */;
INSERT INTO `columna_por_lista` VALUES (1,1),(1,2),(1,3);
/*!40000 ALTER TABLE `columna_por_lista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fecha_dia_evento`
--

DROP TABLE IF EXISTS `fecha_dia_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fecha_dia_evento` (
  `id_fecha_evento` int(11) NOT NULL,
  `activo` bit(1) NOT NULL,
  `agrega` bit(1) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `fecha_evento` date NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_fecha_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fecha_dia_evento`
--

LOCK TABLES `fecha_dia_evento` WRITE;
/*!40000 ALTER TABLE `fecha_dia_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `fecha_dia_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS `historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial` (
  `id_historial` int(11) NOT NULL,
  `clase` varchar(200) DEFAULT NULL,
  `codigo` varchar(50) DEFAULT NULL,
  `descripcion` longtext,
  `fecha_registro` datetime DEFAULT NULL,
  `metodo` varchar(200) DEFAULT NULL,
  `persona_id` int(11) DEFAULT NULL,
  `request` longtext,
  `valor` longtext,
  PRIMARY KEY (`id_historial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

LOCK TABLES `historial` WRITE;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
INSERT INTO `historial` VALUES (2800,'PrincipalController','Historial-1359177102401-2048177213',NULL,'2013-01-26 00:11:42','Usuario se dirige a principal  ip: 127.0.0.1',NULL,NULL,NULL),(2801,'PrincipalController','Historial-1359177102715-485579652',NULL,'2013-01-26 00:11:42','Usuario se dirige a principal  con la lista de menus',NULL,NULL,'[[{\"nombre\":\"Mantenimiento\",\"orden\":0,\"tipo\":\"interno\",\"menus\":[{\"nombre\":\"Parametro\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Parametro\",\"id\":1},{\"nombre\":\"Perfil\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Perfil\",\"id\":1},{\"nombre\":\"Lista\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Lista\",\"id\":1},{\"nombre\":\"Columna\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Columna\",\"id\":1}],\"id\":1}]]'),(2850,'PrincipalController','Historial-1359177218432-2097725879',NULL,'2013-01-26 00:13:38','Usuario se dirige a principal  ip: 127.0.0.1',NULL,NULL,NULL),(2851,'PrincipalController','Historial-1359177218595-900718971',NULL,'2013-01-26 00:13:38','Usuario se dirige a principal  con la lista de menus',NULL,NULL,'[[{\"nombre\":\"Mantenimiento\",\"orden\":0,\"tipo\":\"interno\",\"menus\":[{\"nombre\":\"Parametro\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Parametro\",\"id\":1},{\"nombre\":\"Perfil\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Perfil\",\"id\":1},{\"nombre\":\"Lista\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Lista\",\"id\":1},{\"nombre\":\"Columna\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Columna\",\"id\":1}],\"id\":1}]]'),(2852,'PrincipalController','Historial-1359177318517-352753634',NULL,'2013-01-26 00:15:18','Usuario se dirige a principal  ip: 127.0.0.1',NULL,NULL,NULL),(2853,'PrincipalController','Historial-1359177318623-1731015846',NULL,'2013-01-26 00:15:18','Usuario se dirige a principal  con la lista de menus',NULL,NULL,'[[{\"nombre\":\"Mantenimiento\",\"orden\":0,\"tipo\":\"interno\",\"menus\":[{\"nombre\":\"Parametro\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Parametro\",\"id\":1},{\"nombre\":\"Perfil\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Perfil\",\"id\":1},{\"nombre\":\"Lista\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Lista\",\"id\":1},{\"nombre\":\"Columna\",\"orden\":0,\"tipo\":\"interno\",\"url\":\"Columna\",\"id\":1}],\"id\":1}]]'),(2854,NULL,'Historial-1359177321125-2011970268',NULL,'2013-01-26 00:15:21',NULL,NULL,NULL,'[]'),(2857,NULL,'Historial-1359177322925-1745952667',NULL,'2013-01-26 00:15:22',NULL,NULL,NULL,'[]'),(2860,NULL,'Historial-1359177325556-537068416',NULL,'2013-01-26 00:15:25',NULL,NULL,NULL,'[]'),(2863,NULL,'Historial-1359177326510-210282510',NULL,'2013-01-26 00:15:26',NULL,NULL,NULL,'[]'),(2866,NULL,'Historial-1359177333734-2009445086',NULL,'2013-01-26 00:15:33',NULL,NULL,NULL,'[]'),(2869,NULL,'Historial-1359177522891-637429635',NULL,'2013-01-26 00:18:42',NULL,NULL,NULL,'[]'),(2901,NULL,'Historial-1359177559607-568055061',NULL,'2013-01-26 00:19:19',NULL,NULL,NULL,'[]');
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista`
--

DROP TABLE IF EXISTS `lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista` (
  `codigo` varchar(50) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `tabla` varchar(40) NOT NULL,
  `id_recurso` int(11) NOT NULL,
  PRIMARY KEY (`id_recurso`),
  KEY `FK62363839D62F729` (`id_recurso`),
  CONSTRAINT `FK62363839D62F729` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista`
--

LOCK TABLES `lista` WRITE;
/*!40000 ALTER TABLE `lista` DISABLE KEYS */;
INSERT INTO `lista` VALUES ('rthr5464',1,'Lista de Parametros','Parametro',1);
/*!40000 ALTER TABLE `lista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_por_menu`
--

DROP TABLE IF EXISTS `lista_por_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_por_menu` (
  `lista_id_recurso` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  KEY `FKC943A907579CC787` (`id_menu`),
  KEY `FKC943A9075204655F` (`lista_id_recurso`),
  CONSTRAINT `FKC943A9075204655F` FOREIGN KEY (`lista_id_recurso`) REFERENCES `lista` (`id_recurso`),
  CONSTRAINT `FKC943A907579CC787` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_por_menu`
--

LOCK TABLES `lista_por_menu` WRITE;
/*!40000 ALTER TABLE `lista_por_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_por_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `codigo` varchar(50) NOT NULL,
  `function` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `orden` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `todos` bit(1) NOT NULL,
  `url` longtext,
  `id_recurso` int(11) NOT NULL,
  `menu_id_recurso` int(11) DEFAULT NULL,
  `defaultMenu` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_recurso`),
  KEY `FK33155F9D62F729` (`id_recurso`),
  KEY `FK33155F7F58CF89` (`menu_id_recurso`),
  CONSTRAINT `FK33155F7F58CF89` FOREIGN KEY (`menu_id_recurso`) REFERENCES `menu` (`id_recurso`),
  CONSTRAINT `FK33155F9D62F729` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametro` (
  `id_parametro` int(11) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `codigo` varchar(50) NOT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `tipo` varchar(200) DEFAULT NULL,
  `valor` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_parametro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
INSERT INTO `parametro` VALUES (1,'','parasda12312','fweffefwef','A','1990-10-10','1990-10-10 00:00:00','regex nombre','validate','{a-zA-Z}[3-100]'),(2,'','asdasferg','asdasdsa','A','1990-10-10','1990-10-10 00:00:00','tipos de parametros','tipos','validacion'),(3,'','asdasds','wefewfwefwefwe','A','1990-10-10','1990-10-10 00:00:00','regex apellido','validate','{a-zA-Z}[3-100]');
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro_por_parametro`
--

DROP TABLE IF EXISTS `parametro_por_parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametro_por_parametro` (
  `parametro_id_parametro_hijo` int(11) NOT NULL,
  `parametro_id_parametro_padre` int(11) NOT NULL,
  `orden` int(11) NOT NULL,
  PRIMARY KEY (`parametro_id_parametro_hijo`,`parametro_id_parametro_padre`),
  KEY `FKCE3745C74F167556` (`parametro_id_parametro_padre`),
  KEY `FKCE3745C7FFEF939E` (`parametro_id_parametro_hijo`),
  CONSTRAINT `FKCE3745C74F167556` FOREIGN KEY (`parametro_id_parametro_padre`) REFERENCES `parametro` (`id_parametro`),
  CONSTRAINT `FKCE3745C7FFEF939E` FOREIGN KEY (`parametro_id_parametro_hijo`) REFERENCES `parametro` (`id_parametro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro_por_parametro`
--

LOCK TABLES `parametro_por_parametro` WRITE;
/*!40000 ALTER TABLE `parametro_por_parametro` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametro_por_parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL,
  `activo` bit(1) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `estado` char(1) NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'','12312fwewe','qdqwdqwfqw234','A','1990-10-10','1990-10-10 00:00:00','administrador');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `activo` bit(1) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `estado` char(1) NOT NULL,
  `fechaActualizacion` date DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'','admin','A','1990-10-10','1990-10-10 00:00:00','1990-10-10','admin');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurso`
--

DROP TABLE IF EXISTS `recurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recurso` (
  `id_recurso` int(11) NOT NULL,
  `activo` bit(1) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `estado` char(1) NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  PRIMARY KEY (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso`
--

LOCK TABLES `recurso` WRITE;
/*!40000 ALTER TABLE `recurso` DISABLE KEYS */;
INSERT INTO `recurso` VALUES (1,'','qwdqwdq','A','1990-10-10','1990-10-10 00:00:00');
/*!40000 ALTER TABLE `recurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurso_por_perfil`
--

DROP TABLE IF EXISTS `recurso_por_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recurso_por_perfil` (
  `responsable` bit(1) DEFAULT NULL,
  `id_recurso` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  PRIMARY KEY (`id_perfil`,`id_recurso`),
  KEY `FKCB9764EEEDC96221` (`id_perfil`),
  KEY `FKCB9764EE9D62F729` (`id_recurso`),
  CONSTRAINT `FKCB9764EE9D62F729` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`),
  CONSTRAINT `FKCB9764EEEDC96221` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso_por_perfil`
--

LOCK TABLES `recurso_por_perfil` WRITE;
/*!40000 ALTER TABLE `recurso_por_perfil` DISABLE KEYS */;
INSERT INTO `recurso_por_perfil` VALUES ('\0',1,1);
/*!40000 ALTER TABLE `recurso_por_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence_table`
--

DROP TABLE IF EXISTS `sequence_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence_table` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence_table`
--

LOCK TABLES `sequence_table` WRITE;
/*!40000 ALTER TABLE `sequence_table` DISABLE KEYS */;
INSERT INTO `sequence_table` VALUES ('historial',59);
/*!40000 ALTER TABLE `sequence_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `clave` varchar(50) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `estado_civil` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `numero_documento` varchar(12) NOT NULL,
  `ruc` varchar(11) DEFAULT NULL,
  `tipo_documento` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `FKF814F32ECB6EE1EF` (`id_persona`),
  CONSTRAINT `FKF814F32ECB6EE1EF` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('123456','admin',0,'admin','123123123','1231312312',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_por_perfil`
--

DROP TABLE IF EXISTS `usuario_por_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_por_perfil` (
  `id_usuario` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  KEY `FK8963AE9EDC96221` (`id_perfil`),
  KEY `FK8963AE9C7928F3` (`id_usuario`),
  CONSTRAINT `FK8963AE9C7928F3` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_persona`),
  CONSTRAINT `FK8963AE9EDC96221` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_por_perfil`
--

LOCK TABLES `usuario_por_perfil` WRITE;
/*!40000 ALTER TABLE `usuario_por_perfil` DISABLE KEYS */;
INSERT INTO `usuario_por_perfil` VALUES (1,1);
/*!40000 ALTER TABLE `usuario_por_perfil` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-26 20:41:12
