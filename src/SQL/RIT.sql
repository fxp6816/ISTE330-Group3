
if exists drop database rit;

USE `rit` ;

-- -----------------------------------------------------
-- Table `rit`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`department` (
  `deptID` INT NOT NULL AUTO_INCREMENT,
  `deptName` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`deptID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`faculty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`faculty` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FName` VARCHAR(25) NULL DEFAULT NULL,
  `LName` VARCHAR(25) NULL DEFAULT NULL,
  `departmentID` INT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `faculty_ibfk_1` (`departmentID` ASC) VISIBLE,
  CONSTRAINT `faculty_ibfk_1`
    FOREIGN KEY (`departmentID`)
    REFERENCES `rit`.`department` (`deptID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`faculty_contact_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`faculty_contact_info` (
  `facultyID` INT NOT NULL,
  `phone` VARCHAR(10) NULL DEFAULT NULL,
  `email` VARCHAR(25) NULL DEFAULT NULL,
  `Office Hours` VARCHAR(45) NULL,
  `Office Number` VARCHAR(45) NULL,
  `faculty_contact_infocol` VARCHAR(45) NULL,
  INDEX `faculty_contact_info_ibfk_1` (`facultyID` ASC) VISIBLE,
  CONSTRAINT `faculty_contact_info_ibfk_1`
    FOREIGN KEY (`facultyID`)
    REFERENCES `rit`.`faculty` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`interests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`interests` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `interestDesc` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`program` (
  `programID` INT NOT NULL AUTO_INCREMENT,
  `programName` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`programID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`student` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FName` VARCHAR(25) NULL DEFAULT NULL,
  `LName` VARCHAR(25) NULL DEFAULT NULL,
  `programID` INT NULL DEFAULT NULL,
  `interestID` INT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `student_ibfk_1` (`programID` ASC) VISIBLE,
  INDEX `fk_studentInterestID` (`interestID` ASC) VISIBLE,
  CONSTRAINT `fk_studentInterestID`
    FOREIGN KEY (`interestID`)
    REFERENCES `rit`.`interests` (`ID`),
  CONSTRAINT `student_ibfk_1`
    FOREIGN KEY (`programID`)
    REFERENCES `rit`.`program` (`programID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rit`.`student_contact_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rit`.`student_contact_info` (
  `studentID` INT NULL DEFAULT NULL,
  `phone` VARCHAR(10) NULL DEFAULT NULL,
  `email` VARCHAR(25) NULL DEFAULT NULL,
  INDEX `student_contact_info_ibfk_1` (`studentID` ASC) VISIBLE,
  CONSTRAINT `student_contact_info_ibfk_1`
    FOREIGN KEY (`studentID`)
    REFERENCES `rit`.`student` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

