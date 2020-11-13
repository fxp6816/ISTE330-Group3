-- -----------------------------------------------------
-- Drop Database RIT
-- -----------------------------------------------------
DROP DATABASE IF EXISTS RIT;

-- -----------------------------------------------------
-- Create Database RIT
-- -----------------------------------------------------
CREATE DATABASE RIT;

-- -----------------------------------------------------
-- Use Database RIT
-- -----------------------------------------------------
USE rit ;

-- -----------------------------------------------------
-- Table college
-- -----------------------------------------------------
CREATE TABLE college (
  collegeID INT NOT NULL AUTO_INCREMENT,
  collegeName VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (collegeID));

-- -----------------------------------------------------
-- Table department
-- -----------------------------------------------------
CREATE TABLE department (
  deptID INT NOT NULL AUTO_INCREMENT,
  deptName VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (deptID));

-- -----------------------------------------------------
-- Table interests
-- -----------------------------------------------------
CREATE TABLE interests (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `interestDesc` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`));


-- -----------------------------------------------------
-- Table faculty`
-- -----------------------------------------------------
CREATE TABLE faculty (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FName` VARCHAR(25) NULL DEFAULT NULL,
  `LName` VARCHAR(25) NULL DEFAULT NULL,
  `departmentID` INT NULL DEFAULT NULL,
  `collegeID` INT NULL DEFAULT NULL,
  `interestID` INT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT faculty_ibfk_1
    FOREIGN KEY (`departmentID`)
    REFERENCES department(deptID),
  CONSTRAINT faculty_ibfk_2
    FOREIGN KEY (`collegeID`)
    REFERENCES college(collegeID),
  CONSTRAINT fk_interestID
    FOREIGN KEY (interestID)
    REFERENCES interests(ID)
);

-- -----------------------------------------------------
-- Table faculty_contact_info
-- -----------------------------------------------------
CREATE TABLE faculty_contact_info (
  facultyID INT NOT NULL,
  `phone` VARCHAR(10) NULL DEFAULT NULL,
  `email` VARCHAR(25) NULL DEFAULT NULL,
  CONSTRAINT faculty_contact_info_ibfk_1
    FOREIGN KEY (facultyID)
    REFERENCES faculty(ID)
    ON DELETE CASCADE
);

-- -----------------------------------------------------
-- Table program`
-- -----------------------------------------------------
CREATE TABLE program (
  programID INT NOT NULL AUTO_INCREMENT,
  programName VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (programID)
);

-- -----------------------------------------------------
-- Table student`
-- -----------------------------------------------------
CREATE TABLE student (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FName` VARCHAR(25) NULL DEFAULT NULL,
  `LName` VARCHAR(25) NULL DEFAULT NULL,
  `programID` INT NULL DEFAULT NULL,
  `interestID` INT NULL DEFAULT NULL,
  `collegeID` INT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
    CONSTRAINT student_ibfk_1
    FOREIGN KEY (programID)
    REFERENCES program(programID),
  CONSTRAINT student_ibfk_2
    FOREIGN KEY (collegeID)
    REFERENCES college (collegeID),
  CONSTRAINT fk_studentInterestID
    FOREIGN KEY (`interestID`)
    REFERENCES interests(ID)
);

-- -----------------------------------------------------
-- Table student_contact_info`
-- -----------------------------------------------------
CREATE TABLE student_contact_info (
  `studentID` INT NULL DEFAULT NULL,
  `phone` VARCHAR(10) NULL DEFAULT NULL,
  `email` VARCHAR(25) NULL DEFAULT NULL,
  CONSTRAINT student_contact_info_ibfk_1
    FOREIGN KEY (`studentID`)
    REFERENCES student(ID)
    ON DELETE CASCADE
);

show tables;