-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sceweb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sceweb` DEFAULT CHARACTER SET latin1 ;
USE `sceweb` ;

-- -----------------------------------------------------
-- Table `sceweb`.`empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sceweb`.`empresa` ;

CREATE TABLE IF NOT EXISTS `sceweb`.`empresa` (
  `cnpj` VARCHAR(14) NOT NULL COMMENT '',
  `nomeDaEmpresa` VARCHAR(45) NOT NULL COMMENT '',
  `nomeFantasia` VARCHAR(45) NOT NULL COMMENT '',
  `endereco` VARCHAR(45) NOT NULL COMMENT '',
  `telefone` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`cnpj`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sceweb`.`convenio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sceweb`.`convenio` ;

CREATE TABLE IF NOT EXISTS `sceweb`.`convenio` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `empresa_cnpj` VARCHAR(14) NOT NULL COMMENT '',
  `dataInicio` DATE NOT NULL COMMENT '',
  `dataFim` DATE NOT NULL COMMENT '',
  INDEX `fk_convenio_empresa_idx` (`empresa_cnpj` ASC)  COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `fk_convenio_empresa`
    FOREIGN KEY (`empresa_cnpj`)
    REFERENCES `sceweb`.`empresa` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sceweb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sceweb`.`usuario` ;

CREATE TABLE IF NOT EXISTS `sceweb`.`usuario` (
  `userID` VARCHAR(255) NOT NULL COMMENT '',
  `senha` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`userID`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;