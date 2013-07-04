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
  `bloqueable` tinyint(1) DEFAULT NULL,
  `icono` varchar(50) DEFAULT NULL,
  `on_complete` varchar(80) DEFAULT NULL,
  `on_submit` varchar(80) DEFAULT NULL,
  `on_click` varchar(80) DEFAULT NULL,
  `orden` int(11) NOT NULL,
  `parametros_json` longtext,
  `tipo` varchar(50) NOT NULL,
  `url` varchar(250) DEFAULT NULL,
  `id_recurso` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_recurso`),
  KEY `FK59935E6CFD4B9F4` (`id_recurso`),
  CONSTRAINT `FK59935E6CFD4B9F4` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `boton`
--

/*!40000 ALTER TABLE `boton` DISABLE KEYS */;
INSERT INTO `boton` (`bloqueable`,`icono`,`on_complete`,`on_submit`,`on_click`,`orden`,`parametros_json`,`tipo`,`url`,`id_recurso`,`nombre`) VALUES 
 (1,'ui-icon ui-icon-note',NULL,NULL,NULL,1,NULL,'nuevo','mantenimiento/registrarParametro/Formulario_Parametro',3,'Nuevo'),
 (1,'ui-icon ui-icon-folder-open','guardar_complete','guardar_submit','',1,NULL,'formulario','mantenimiento/guardarParametro',4,'Grabar');
/*!40000 ALTER TABLE `boton` ENABLE KEYS */;


--
-- Definition of table `boton_por_formulario`
--

DROP TABLE IF EXISTS `boton_por_formulario`;
CREATE TABLE `boton_por_formulario` (
  `id_formulario` int(11) NOT NULL,
  `id_recurso` int(11) NOT NULL,
  PRIMARY KEY (`id_formulario`,`id_recurso`),
  KEY `Index_3` (`id_formulario`),
  KEY `FK_boton_por_formulario_1` (`id_recurso`),
  CONSTRAINT `FK_boton_por_formulario_1` FOREIGN KEY (`id_recurso`) REFERENCES `boton` (`id_recurso`),
  CONSTRAINT `FK_boton_por_formulario_2` FOREIGN KEY (`id_formulario`) REFERENCES `formulario` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `boton_por_formulario`
--

/*!40000 ALTER TABLE `boton_por_formulario` DISABLE KEYS */;
INSERT INTO `boton_por_formulario` (`id_formulario`,`id_recurso`) VALUES 
 (16,4);
/*!40000 ALTER TABLE `boton_por_formulario` ENABLE KEYS */;


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
INSERT INTO `boton_por_menu` (`id_menu`,`id_recurso`) VALUES 
 (2,3);
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
  `activo` tinyint(1) NOT NULL,
  `addColumn` tinyint(1) NOT NULL,
  `alineacion` varchar(50) DEFAULT NULL,
  `ancho` int(11) NOT NULL,
  `atributo` varchar(50) NOT NULL,
  `cabecera` varchar(50) DEFAULT NULL,
  `codigo` varchar(50) NOT NULL,
  `estado` char(1) DEFAULT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `formato_tipo` varchar(50) NOT NULL,
  `mapping` tinyint(1) NOT NULL,
  `orden` int(11) NOT NULL,
  `tabla` varchar(50) NOT NULL,
  `visible` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_columna`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `columna`
--

/*!40000 ALTER TABLE `columna` DISABLE KEYS */;
INSERT INTO `columna` (`id_columna`,`activo`,`addColumn`,`alineacion`,`ancho`,`atributo`,`cabecera`,`codigo`,`estado`,`fecha_actualizacion`,`fecha_registro`,`formato_tipo`,`mapping`,`orden`,`tabla`,`visible`) VALUES 
 (1,1,1,NULL,0,'id',NULL,'wefewfwf',NULL,NULL,NULL,'wefwe',1,1,'Parametro',0),
 (2,1,1,NULL,100,'codigo','Codigo','wefewf',NULL,NULL,NULL,'wefwefgeytjty',1,2,'Parametro',1),
 (3,1,1,NULL,100,'activo','Activo','gghrttr3ewf',NULL,NULL,NULL,'fwefweegweg',1,3,'Parametro',1),
 (4,1,1,NULL,100,'descripcion','Descripcion','gghrttr3ewf45',NULL,NULL,NULL,'wefew',1,4,'Parametro',1),
 (5,1,1,NULL,100,'valor','Valor','gghrttr3ewf455634',NULL,NULL,NULL,'fwewefew',1,5,'Parametro',1),
 (6,1,1,NULL,0,'id',NULL,'weffewfef',NULL,NULL,NULL,'qwdwqd',1,1,'Perfil',0),
 (7,1,1,NULL,100,'codigo','Codigo','wfweewht2',NULL,NULL,NULL,'ewfewfefew',1,2,'Perfil',1),
 (8,1,1,NULL,100,'descripcion','Descripcion','wefewfwf',NULL,NULL,NULL,'wefwe',1,3,'Perfil',1),
 (9,1,1,NULL,100,'estado','Estado','wefewf',NULL,NULL,NULL,'wefwefgeytjty',1,4,'Perfil',1),
 (10,1,1,NULL,100,'nombre','Nombre','gghrttr3ewf',NULL,NULL,NULL,'fwefweegweg',1,5,'Perfil',1),
 (11,1,1,NULL,0,'id',NULL,'fewwe',NULL,NULL,NULL,'wefew',1,1,'Lista',0),
 (12,1,1,NULL,100,'nombre','Nombre','gghrttr3ewf455634',NULL,NULL,NULL,'fwewefew',1,2,'Lista',1),
 (13,1,1,NULL,100,'tabla','Tabla','weffewfef',NULL,NULL,NULL,'qwdwqd',1,3,'Lista',1),
 (14,1,1,NULL,100,'idMenu','Menu','wfweewht2',NULL,NULL,NULL,'ewfewfefew',1,4,'Lista',1),
 (15,1,1,NULL,100,'id',NULL,'regre',NULL,NULL,NULL,'wefwe',1,1,'Menu',0),
 (16,1,1,NULL,100,'nombre','Nombre','hytjyj',NULL,NULL,NULL,'jytjjtyjty',1,2,'Menu',1),
 (17,1,1,NULL,100,'url','Url','ergerg',NULL,NULL,NULL,'wefewf',1,3,'Menu',1),
 (18,1,1,NULL,100,'orden','Orden','jyt',NULL,NULL,NULL,'gewg',1,4,'Menu',1),
 (19,1,1,NULL,100,'tipo','Tipo','kuyk',NULL,NULL,NULL,'weg',1,5,'Menu',1),
 (20,1,1,NULL,100,'todos','Todos','kuykuy',NULL,NULL,NULL,'hthtrhtrh',1,6,'Menu',1),
 (21,1,1,NULL,0,'id',NULL,'qewdffewf',NULL,NULL,NULL,'wfew',1,1,'Usuario',0),
 (22,1,1,NULL,100,'nombre','Nombre','wefewfewg',NULL,NULL,NULL,'fwethtrhr',1,2,'Usuario',1);
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
INSERT INTO `columna_por_lista` (`id_columna`,`id_recurso`) VALUES 
 (1,1),
 (2,1),
 (3,1),
 (4,1),
 (5,1),
 (6,6),
 (7,6),
 (8,6),
 (9,6),
 (10,6),
 (11,8),
 (12,8),
 (13,8),
 (14,8),
 (21,10),
 (22,10),
 (15,14),
 (16,14),
 (17,14),
 (18,14),
 (19,14),
 (20,14);
/*!40000 ALTER TABLE `columna_por_lista` ENABLE KEYS */;


--
-- Definition of table `fecha_dia_evento`
--

DROP TABLE IF EXISTS `fecha_dia_evento`;
CREATE TABLE `fecha_dia_evento` (
  `id_fecha_evento` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `agrega` tinyint(1) NOT NULL,
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
-- Definition of table `formulario`
--

DROP TABLE IF EXISTS `formulario`;
CREATE TABLE `formulario` (
  `id_recurso` int(11) NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_recurso`),
  KEY `Index_2` (`id_recurso`),
  CONSTRAINT `FK_formulario_1` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `formulario`
--

/*!40000 ALTER TABLE `formulario` DISABLE KEYS */;
INSERT INTO `formulario` (`id_recurso`,`titulo`,`descripcion`) VALUES 
 (16,'Formulario Parametro','Formulario Parametro');
/*!40000 ALTER TABLE `formulario` ENABLE KEYS */;


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
 (2,'Parametro','Parametro',1),
 (5,'Perfil','Perfil',6),
 (7,'Lista','Lista',8),
 (9,'Usuario','Usuario',10),
 (11,'Fecha Evento','Fecha Evento',12),
 (13,'Menu','Menu',14);
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
  `defaultMenu` tinyint(1) DEFAULT NULL,
  `function` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `orden` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `todos` tinyint(1) NOT NULL,
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
 (1,NULL,'Parametro',0,'interno',0,'Parametro',2,15),
 (0,NULL,'Perfil',1,'interno',0,'Perfil',5,15),
 (0,NULL,'Lista',2,'interno',0,'Lista',7,15),
 (0,NULL,'Usuario',3,'interno',0,'Usuario',9,15),
 (0,NULL,'Fechas Evento',4,'interno',0,'Fechas Evento',11,15),
 (0,NULL,'Mantenimiento',0,'interno',0,'Mantenimiento',15,NULL),
 (0,NULL,'Contenido Alfresco',1,'interno',1,'Contenido_Alfresco',17,NULL),
 (0,NULL,'Contenido Texto',0,'interno',1,'Contenido_Texto',18,17);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;


--
-- Definition of table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
CREATE TABLE `parametro` (
  `id_parametro` int(11) NOT NULL,
  `activo` tinyint(1) DEFAULT NULL,
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
INSERT INTO `parametro` (`id_parametro`,`activo`,`codigo`,`descripcion`,`estado`,`fecha_actualizacion`,`fecha_registro`,`nombre`,`tipo`,`valor`) VALUES 
 (1,1,'rules','rules','A','1990-10-10','1990-10-10 00:00:00','rules','rules',''),
 (2,1,'val_nombre','Validar Nombre','A','1990-10-10','1990-10-10 00:00:00','Validar Nombre','validar','patron'),
 (3,1,'val_codigo','Validar Codigo','A','1990-10-10','1990-10-10 00:00:00','Validar Codigo','validar','patron'),
 (4,1,'tipos','tipos','A','1990-10-10','1990-10-10 00:00:00','Tipos','tipo',NULL),
 (5,1,'estados','estados','A','1990-10-10','1990-10-10 00:00:00','Estados','estados',NULL),
 (6,1,'Formulario_Parametro','validar formulario parametro','A','1990-10-10','1990-10-10 00:00:00','Validar Parametro','validar',NULL),
 (7,1,'messages','messages','A','1990-10-10','1990-10-10 00:00:00','messages','messages',NULL),
 (8,1,'msg_nombre','msj nombre','A','1990-10-10','1990-10-10 00:00:00','Mensaje Nombre','mensaje','El nombre es incorrecto'),
 (9,1,'msg_codigo','msj codigo','A','1990-10-10','1990-10-10 00:00:00','Mensaje Codigo','mensaje','El codigo es incorrecto');
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
INSERT INTO `parametro_por_parametro` (`parametro_id_parametro_hijo`,`parametro_id_parametro_padre`,`orden`) VALUES 
 (1,6,0),
 (2,1,1),
 (3,1,2),
 (7,6,0),
 (8,7,1),
 (9,7,2);
/*!40000 ALTER TABLE `parametro_por_parametro` ENABLE KEYS */;


--
-- Definition of table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
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
 (1,1,'12312fwewe','qdqwdqwfqw234','A','1990-10-10','1990-10-10 00:00:00','administrador');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;


--
-- Definition of table `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
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
 (1,1,'admin',NULL,'63432','A','1990-10-10','1990-10-10 00:00:00','1990-10-10','admin',NULL);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;


--
-- Definition of table `recurso`
--

DROP TABLE IF EXISTS `recurso`;
CREATE TABLE `recurso` (
  `id_recurso` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
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
 (1,1,'Parametro','Lista Parametro','A','1990-10-10','1990-10-10 00:00:00'),
 (2,1,'Parametro','Menu Parametro','A','1990-10-10','1990-10-10 00:00:00'),
 (3,1,'Boton_Nuevo','Boton Nuevo','A','1990-10-10','1990-10-10 00:00:00'),
 (4,1,'Boton_Guardar','Boton Guardar','A','1990-10-10','1990-10-10 00:00:00'),
 (5,1,'Perfil','Menu Perfil','A','1990-10-10','1990-10-10 00:00:00'),
 (6,1,'Perfil','Lista Perfil','A','1990-10-10','1990-10-10 00:00:00'),
 (7,1,'Lista','Menu Lista','A','1990-10-10','1990-10-10 00:00:00'),
 (8,1,'Lista','Lista Lista','A','1990-10-10','1990-10-10 00:00:00'),
 (9,1,'Usuario','Menu Usuario','A','1990-10-10','1990-10-10 00:00:00'),
 (10,1,'Usuario','Lista Usuario','A','1990-10-10','1990-10-10 00:00:00'),
 (11,1,'FechaDiaEvento','Menu Fechas Evento','A','1990-10-10','1990-10-10 00:00:00'),
 (12,1,'FechaDiaEvento','Lista Fechas Evento','A','1990-10-10','1990-10-10 00:00:00'),
 (13,1,'Menu','Menu Menu','A','1990-10-10','1990-10-10 00:00:00'),
 (14,1,'Menu','Lista Menu','A','1990-10-10','1990-10-10 00:00:00'),
 (15,1,'Mantenimiento','Mantenimiento','A','1990-10-10','1990-10-10 00:00:00'),
 (16,1,'Formulario_Parametro','Formulario Parametro','A','1990-10-10','1990-10-10 00:00:00'),
 (17,1,'Contenidos_Alfresco','Contenidos Alfresco','A','1990-10-10','1990-10-10 00:00:00'),
 (18,1,'Contenido_Texto','Contenido Texto','A','1990-10-10','1990-10-10 00:00:00');
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
 (NULL,1,1),
 (NULL,2,1),
 (NULL,3,1),
 (NULL,4,1),
 (NULL,5,1),
 (NULL,6,1),
 (NULL,7,1),
 (NULL,8,1),
 (NULL,9,1),
 (NULL,10,1),
 (NULL,11,1),
 (NULL,12,1),
 (NULL,13,1),
 (NULL,14,1),
 (NULL,15,1),
 (NULL,17,1),
 (NULL,18,1);
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
