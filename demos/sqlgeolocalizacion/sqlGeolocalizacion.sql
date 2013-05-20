SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `geolocalizacion` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci ;
USE `geolocalizacion` ;

-- -----------------------------------------------------
-- Table `geolocalizacion`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geolocalizacion`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `geolocalizacion`.`usuario` (
  `id_usuario` INT(11) NOT NULL ,
  `nombres_completo` VARCHAR(100) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `apellidos_completos` VARCHAR(100) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `fecha_nacimiento` DATETIME NULL DEFAULT NULL ,
  `fecha_registro` DATETIME NULL DEFAULT NULL ,
  `fecha_actualizacion` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`id_usuario`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `geolocalizacion`.`telefono`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geolocalizacion`.`telefono` ;

CREATE  TABLE IF NOT EXISTS `geolocalizacion`.`telefono` (
  `id_usuario` INT(11) NOT NULL ,
  `tipo_telefono` VARCHAR(45) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `numero` VARCHAR(45) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  INDEX `fk_telefonos_1_idx` (`id_usuario` ASC) ,
  CONSTRAINT `fk_telefonos_1`
    FOREIGN KEY (`id_usuario` )
    REFERENCES `geolocalizacion`.`usuario` (`id_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `geolocalizacion`.`geolocalizacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geolocalizacion`.`geolocalizacion` ;

CREATE  TABLE IF NOT EXISTS `geolocalizacion`.`geolocalizacion` (
  `id_geolocalizacion` INT(11) NOT NULL ,
  `telefonos_id_usuario` INT(11) NOT NULL ,
  `fecha_registro` DATETIME NULL ,
  PRIMARY KEY (`id_geolocalizacion`) ,
  INDEX `fk_geolocalizacion_telefonos1_idx` (`telefonos_id_usuario` ASC) ,
  CONSTRAINT `fk_geolocalizacion_telefonos1`
    FOREIGN KEY (`telefonos_id_usuario` )
    REFERENCES `geolocalizacion`.`telefono` (`id_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `geolocalizacion`.`punto_geolocalizacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geolocalizacion`.`punto_geolocalizacion` ;

CREATE  TABLE IF NOT EXISTS `geolocalizacion`.`punto_geolocalizacion` (
  `latitud` VARCHAR(45) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `longitud` VARCHAR(45) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `geolocalizacion_id_geolocalizacion` INT(11) NOT NULL ,
  `id_punto` INT(11) NOT NULL ,
  `fecha_registro` DATETIME NULL ,
  PRIMARY KEY (`id_punto`) ,
  CONSTRAINT `fk_geolocalizacion_copy1_geolocalizacion1`
    FOREIGN KEY (`geolocalizacion_id_geolocalizacion` )
    REFERENCES `geolocalizacion`.`geolocalizacion` (`id_geolocalizacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
