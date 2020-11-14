-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Drop rit
-- -----------------------------------------------------
drop database rit;
-- -----------------------------------------------------
-- Schema rit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rit` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema candidateskills
-- -----------------------------------------------------
USE `rit` ;

-- -----------------------------------------------------
-- Table `rit`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`department` (
  `deptID` INT NOT NULL AUTO_INCREMENT,
  `deptName` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`deptID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



-- -----------------------------------------------------
-- Table `rit`.`faculty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`faculty` (
  `ID` INT NOT NULL,
  `FName` VARCHAR(25) NULL DEFAULT NULL,
  `LName` VARCHAR(25) NULL DEFAULT NULL,
  `abstracts` VARCHAR(2000) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`faculty_contact_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`faculty_contact_info` (
  `facultyID` INT NOT NULL,
  `phone` VARCHAR(10) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `Office Hours` VARCHAR(255) NOT NULL,
  `Office Number` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`facultyID`),
  INDEX `faculty_contact_info_ibfk_1` (`facultyID` ASC) VISIBLE,
  CONSTRAINT `faculty_contact_info_ibfk_1`
    FOREIGN KEY (`facultyID`)
    REFERENCES `rit`.`faculty` (`ID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`faculty_department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`faculty_department` (
  `facultyID` INT NOT NULL,
  `departmentID` INT NOT NULL,
  PRIMARY KEY (`facultyID`),
  INDEX `faculty_department_faculty_FK_idx` (`departmentID` ASC) VISIBLE,
  CONSTRAINT `faculty_department_department_FK`
    FOREIGN KEY (`departmentID`)
    REFERENCES `rit`.`department` (`deptID`)
    ON DELETE CASCADE,
  CONSTRAINT `faculty_department_faculty_FK`
    FOREIGN KEY (`facultyID`)
    REFERENCES `rit`.`faculty` (`ID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `rit`.`department`
(`deptName`)
VALUES
('CIT');

INSERT INTO `rit`.`department`
(`deptName`)
VALUES
('Computer Science');

INSERT INTO `rit`.`department`
(`deptName`)
VALUES
('Software Engineering');

INSERT INTO `rit`.`department`
(`deptName`)
VALUES
('Hardware Engineering');

INSERT INTO `rit`.`department`
(`deptName`)
VALUES
('Micro Electronic Engineering');


-- -----------------------------------------------------
-- Table `rit`.`interests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`interests` (
  `interestID` INT NOT NULL AUTO_INCREMENT,
  `interestDesc` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`interestID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`program` (
  `programID` INT NOT NULL AUTO_INCREMENT,
  `programName` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`programID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`student` (
  `ID` INT NOT NULL,
  `FName` VARCHAR(25) NULL DEFAULT NULL,
  `LName` VARCHAR(25) NULL DEFAULT NULL,
  `programID` INT NULL DEFAULT NULL,
  `interestID` INT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`student_contact_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`student_contact_info` (
  `studentID` INT NULL DEFAULT NULL,
  `phone` VARCHAR(10) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  INDEX `student_contact_info_ibfk_1` (`studentID` ASC) VISIBLE,
  CONSTRAINT `student_contact_info_ibfk_1`
    FOREIGN KEY (`studentID`)
    REFERENCES `rit`.`student` (`ID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`student_interest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`student_interest` (
  `studentID` INT NOT NULL,
  `interestID` INT NOT NULL,
  PRIMARY KEY (`studentID`, `interestID`),
  INDEX `student_interest_interest_FK_idx` (`interestID` ASC) VISIBLE,
  CONSTRAINT `student_interest_interest_FK`
    FOREIGN KEY (`interestID`)
    REFERENCES `rit`.`interests` (`interestID`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `student_interest_student_FK`
    FOREIGN KEY (`studentID`)
    REFERENCES `rit`.`student` (`ID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `rit`.`interests`
(`interestDesc`)
VALUES
('C#');

INSERT INTO `rit`.`interests`
(`interestDesc`)
VALUES
('Ruby');

INSERT INTO `rit`.`interests`
(`interestDesc`)
VALUES
('Python');

INSERT INTO `rit`.`interests`
(`interestDesc`)
VALUES
('C++');

INSERT INTO `rit`.`interests`
(`interestDesc`)
VALUES
('Java');

-- -----------------------------------------------------
-- Table `rit`.`student_program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`student_program` (
  `studentID` INT NOT NULL,
  `programID` INT NOT NULL,
  PRIMARY KEY (`studentID`, `programID`),
  INDEX `student_program_program_FK_idx` (`programID` ASC) VISIBLE,
  CONSTRAINT `student_program_program_FK`
    FOREIGN KEY (`programID`)
    REFERENCES `rit`.`program` (`programID`)
    ON DELETE CASCADE,
  CONSTRAINT `student_program_student_FK`
    FOREIGN KEY (`studentID`)
    REFERENCES `rit`.`student` (`ID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


INSERT INTO `rit`.`program`
(`programName`)
VALUES
('CIT');

INSERT INTO `rit`.`program`
(`programName`)
VALUES
('Computer Science');

INSERT INTO `rit`.`program`
(`programName`)
VALUES
('Software Engineering');

INSERT INTO `rit`.`program`
(`programName`)
VALUES
('Hardware Engineering');

INSERT INTO `rit`.`program`
(`programName`)
VALUES
('Micro Electronic Engineering');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
