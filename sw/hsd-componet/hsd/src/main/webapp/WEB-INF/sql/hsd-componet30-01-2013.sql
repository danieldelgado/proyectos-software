-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.40-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema hsd
--

CREATE DATABASE IF NOT EXISTS hsd;
USE hsd;

--
-- Definition of table `boton`
--

DROP TABLE IF EXISTS `boton`;
CREATE TABLE `boton` (
  `bloqueable` bit(1) NOT NULL,
  `icono` varchar(50) DEFAULT NULL,
  `on_complete` varchar(80) DEFAULT NULL,
  `on_submit` varchar(80) DEFAULT NULL,
  `on_click` varchar(80) DEFAULT NULL,
  `orden` int(11) NOT NULL,
  `parametros_json` longtext,
  `tipo` varchar(50) NOT NULL,
  `url` varchar(250) DEFAULT NULL,
  `id_recurso` int(11) NOT NULL,
  PRIMARY KEY (`id_recurso`),
  KEY `FK59935E6CFD4B9F4` (`id_recurso`),
  CONSTRAINT `FK59935E6CFD4B9F4` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `boton`
--

/*!40000 ALTER TABLE `boton` DISABLE KEYS */;
/*!40000 ALTER TABLE `boton` ENABLE KEYS */;


--
-- Definition of table `boton_por_menu`
--

DROP TABLE IF EXISTS `boton_por_menu`;
CREATE TABLE `boton_por_menu` (
  `id_menu` int(11) NOT NULL,
  `id_recurso` int(11) NOT NULL,
  PRIMARY KEY (`id_recurso`,`id_menu`),
  KEY `FK14A0D604E4CD7F11` (`id_recurso`),
  KEY `FK14A0D604D5F7F09C` (`id_menu`),
  CONSTRAINT `FK14A0D604D5F7F09C` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_recurso`),
  CONSTRAINT `FK14A0D604E4CD7F11` FOREIGN KEY (`id_recurso`) REFERENCES `boton` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `boton_por_menu`
--

/*!40000 ALTER TABLE `boton_por_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `boton_por_menu` ENABLE KEYS */;


--
-- Definition of table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `estado_civil` int(11) NOT NULL,
  `numero_documento` varchar(12) NOT NULL,
  `ruc` varchar(11) NOT NULL,
  `tipo_documento` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `FK334B85FAFDE0A4BA` (`id_persona`),
  CONSTRAINT `FK334B85FAFDE0A4BA` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Definition of table `columna`
--

DROP TABLE IF EXISTS `columna`;
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

--
-- Dumping data for table `columna`
--

/*!40000 ALTER TABLE `columna` DISABLE KEYS */;
/*!40000 ALTER TABLE `columna` ENABLE KEYS */;


--
-- Definition of table `columna_por_lista`
--

DROP TABLE IF EXISTS `columna_por_lista`;
CREATE TABLE `columna_por_lista` (
  `id_columna` int(11) NOT NULL,
  `id_recurso` int(11) NOT NULL,
  PRIMARY KEY (`id_columna`,`id_recurso`),
  KEY `FK303EBF23E557ACAE` (`id_recurso`),
  KEY `FK303EBF23BFF834F8` (`id_columna`),
  CONSTRAINT `FK303EBF23BFF834F8` FOREIGN KEY (`id_columna`) REFERENCES `columna` (`id_columna`),
  CONSTRAINT `FK303EBF23E557ACAE` FOREIGN KEY (`id_recurso`) REFERENCES `lista` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `columna_por_lista`
--

/*!40000 ALTER TABLE `columna_por_lista` DISABLE KEYS */;
/*!40000 ALTER TABLE `columna_por_lista` ENABLE KEYS */;


--
-- Definition of table `fecha_dia_evento`
--

DROP TABLE IF EXISTS `fecha_dia_evento`;
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

--
-- Dumping data for table `fecha_dia_evento`
--

/*!40000 ALTER TABLE `fecha_dia_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `fecha_dia_evento` ENABLE KEYS */;


--
-- Definition of table `historial`
--

DROP TABLE IF EXISTS `historial`;
CREATE TABLE `historial` (
  `id_historial` int(11) NOT NULL,
  `codigo` varchar(50) DEFAULT NULL,
  `descripcion` longtext,
  `fecha_registro` datetime DEFAULT NULL,
  `objeto_json` longtext,
  `request` longtext,
  PRIMARY KEY (`id_historial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `historial`
--

/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;


--
-- Definition of table `lista`
--

DROP TABLE IF EXISTS `lista`;
CREATE TABLE `lista` (
  `id_menu` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `tabla` varchar(40) NOT NULL,
  `id_recurso` int(11) NOT NULL,
  PRIMARY KEY (`id_recurso`),
  KEY `FK6236383CFD4B9F4` (`id_recurso`),
  CONSTRAINT `FK6236383CFD4B9F4` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lista`
--

/*!40000 ALTER TABLE `lista` DISABLE KEYS */;
INSERT INTO `lista` (`id_menu`,`nombre`,`tabla`,`id_recurso`) VALUES 
 (2,'Parametro','Parametro',1);
/*!40000 ALTER TABLE `lista` ENABLE KEYS */;


--
-- Definition of table `lista_por_menu`
--

DROP TABLE IF EXISTS `lista_por_menu`;
CREATE TABLE `lista_por_menu` (
  `id_lista` int(11) NOT NULL,
  `id_recurso` int(11) NOT NULL,
  PRIMARY KEY (`id_lista`,`id_recurso`),
  KEY `FKC943A9075D6B79BE` (`id_recurso`),
  KEY `FKC943A907E8EDBCE8` (`id_lista`),
  CONSTRAINT `FKC943A907E8EDBCE8` FOREIGN KEY (`id_lista`) REFERENCES `lista` (`id_recurso`),
  CONSTRAINT `FKC943A9075D6B79BE` FOREIGN KEY (`id_recurso`) REFERENCES `menu` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lista_por_menu`
--

/*!40000 ALTER TABLE `lista_por_menu` DISABLE KEYS */;
INSERT INTO `lista_por_menu` (`id_lista`,`id_recurso`) VALUES 
 (1,2);
/*!40000 ALTER TABLE `lista_por_menu` ENABLE KEYS */;


--
-- Definition of table `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `defaultMenu` bit(1) DEFAULT NULL,
  `function` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `orden` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `todos` bit(1) NOT NULL,
  `url` longtext,
  `id_recurso` int(11) NOT NULL,
  `menu_id_recurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_recurso`),
  KEY `FK33155FCFD4B9F4` (`id_recurso`),
  KEY `FK33155FFDB3F89E` (`menu_id_recurso`),
  CONSTRAINT `FK33155FCFD4B9F4` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`),
  CONSTRAINT `FK33155FFDB3F89E` FOREIGN KEY (`menu_id_recurso`) REFERENCES `menu` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`defaultMenu`,`function`,`nombre`,`orden`,`tipo`,`todos`,`url`,`id_recurso`,`menu_id_recurso`) VALUES 
 (0x01,NULL,'Paramtro',0,'interno',0x00,'Parametro',2,NULL);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;


--
-- Definition of table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
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

--
-- Dumping data for table `parametro`
--

/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;


--
-- Definition of table `parametro_por_parametro`
--

DROP TABLE IF EXISTS `parametro_por_parametro`;
CREATE TABLE `parametro_por_parametro` (
  `parametro_id_parametro_hijo` int(11) NOT NULL,
  `parametro_id_parametro_padre` int(11) NOT NULL,
  `orden` int(11) NOT NULL,
  PRIMARY KEY (`parametro_id_parametro_hijo`,`parametro_id_parametro_padre`),
  KEY `FKCE3745C7AC22B161` (`parametro_id_parametro_padre`),
  KEY `FKCE3745C75CFBCFA9` (`parametro_id_parametro_hijo`),
  CONSTRAINT `FKCE3745C75CFBCFA9` FOREIGN KEY (`parametro_id_parametro_hijo`) REFERENCES `parametro` (`id_parametro`),
  CONSTRAINT `FKCE3745C7AC22B161` FOREIGN KEY (`parametro_id_parametro_padre`) REFERENCES `parametro` (`id_parametro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parametro_por_parametro`
--

/*!40000 ALTER TABLE `parametro_por_parametro` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametro_por_parametro` ENABLE KEYS */;


--
-- Definition of table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
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

--
-- Dumping data for table `perfil`
--

/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` (`id_perfil`,`activo`,`codigo`,`descripcion`,`estado`,`fecha_actualizacion`,`fecha_creacion`,`nombre`) VALUES 
 (1,0x01,'12312fwewe','qdqwdqwfqw234','A','1990-10-10','1990-10-10 00:00:00','administrador');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;


--
-- Definition of table `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `activo` bit(1) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `celular` varchar(11) DEFAULT NULL,
  `codigo` varchar(50) NOT NULL,
  `estado` char(1) NOT NULL,
  `fechaActualizacion` date DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono_fijo` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persona`
--

/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`id_persona`,`activo`,`apellidos`,`celular`,`codigo`,`estado`,`fechaActualizacion`,`fecha_creacion`,`fecha_nacimiento`,`nombre`,`telefono_fijo`) VALUES 
 (1,0x01,'admin',NULL,'63432','A','1990-10-10','1990-10-10 00:00:00','1990-10-10','admin',NULL);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;


--
-- Definition of table `recurso`
--

DROP TABLE IF EXISTS `recurso`;
CREATE TABLE `recurso` (
  `id_recurso` int(11) NOT NULL,
  `activo` bit(1) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `estado` char(1) NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  PRIMARY KEY (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recurso`
--

/*!40000 ALTER TABLE `recurso` DISABLE KEYS */;
INSERT INTO `recurso` (`id_recurso`,`activo`,`codigo`,`descripcion`,`estado`,`fecha_actualizacion`,`fecha_creacion`) VALUES 
 (1,0x01,'Parametro','sadasd','A','1990-10-10','1990-10-10 00:00:00'),
 (2,0x01,'Menu','asdsada','A','1990-10-10','1990-10-10 00:00:00');
/*!40000 ALTER TABLE `recurso` ENABLE KEYS */;


--
-- Definition of table `recurso_por_perfil`
--

DROP TABLE IF EXISTS `recurso_por_perfil`;
CREATE TABLE `recurso_por_perfil` (
  `responsable` bit(1) DEFAULT NULL,
  `id_recurso` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  PRIMARY KEY (`id_perfil`,`id_recurso`),
  KEY `FKCB9764EE41FE99F6` (`id_perfil`),
  KEY `FKCB9764EECFD4B9F4` (`id_recurso`),
  CONSTRAINT `FKCB9764EECFD4B9F4` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`),
  CONSTRAINT `FKCB9764EE41FE99F6` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recurso_por_perfil`
--

/*!40000 ALTER TABLE `recurso_por_perfil` DISABLE KEYS */;
INSERT INTO `recurso_por_perfil` (`responsable`,`id_recurso`,`id_perfil`) VALUES 
 (NULL,1,1);
/*!40000 ALTER TABLE `recurso_por_perfil` ENABLE KEYS */;


--
-- Definition of table `sequence_table`
--

DROP TABLE IF EXISTS `sequence_table`;
CREATE TABLE `sequence_table` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequence_table`
--

/*!40000 ALTER TABLE `sequence_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `sequence_table` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `clave` varchar(50) NOT NULL,
  `estado_civil` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `numero_documento` varchar(12) NOT NULL,
  `ruc` varchar(11) DEFAULT NULL,
  `tipo_documento` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `FKF814F32EFDE0A4BA` (`id_persona`),
  CONSTRAINT `FKF814F32EFDE0A4BA` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`clave`,`estado_civil`,`login`,`numero_documento`,`ruc`,`tipo_documento`,`id_persona`) VALUES 
 ('123456',1,'admin','123213','32131',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


--
-- Definition of table `usuario_por_perfil`
--

DROP TABLE IF EXISTS `usuario_por_perfil`;
CREATE TABLE `usuario_por_perfil` (
  `id_usuario` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  KEY `FK8963AE941FE99F6` (`id_perfil`),
  KEY `FK8963AE93EEAEBBE` (`id_usuario`),
  CONSTRAINT `FK8963AE93EEAEBBE` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_persona`),
  CONSTRAINT `FK8963AE941FE99F6` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario_por_perfil`
--

/*!40000 ALTER TABLE `usuario_por_perfil` DISABLE KEYS */;
INSERT INTO `usuario_por_perfil` (`id_usuario`,`id_perfil`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `usuario_por_perfil` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
