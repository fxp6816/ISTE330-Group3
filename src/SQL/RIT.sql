-- Testing
-- drop the db if already there
DROP DATABASE IF EXISTS RIT;

CREATE DATABASE RIT;

CREATE TABLE college (
    collegeID int AUTO_INCREMENT not null PRIMARY  KEY,
    collegeName VARCHAR(255)
);

CREATE TABLE department (
    deptID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    deptName VARCHAR(25)
);

CREATE TABLE faculty (
    ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    FName VARCHAR(25),
    LName VARCHAR(25),
    departmentID INT,
    collegeID int,
    FOREIGN KEY (departmentID) REFERENCES department(deptID),
    FOREIGN KEY (collegeID) REFERENCES college(collegeID)
);

CREATE TABLE faculty_Contact_Info (
    facultyID INT NOT NULL ,
    phone VARCHAR(10),
    email VARCHAR(25),
    FOREIGN KEY (facultyID) REFERENCES faculty(ID)
);

CREATE TABLE faculty_Interest (
    facultyID INT,
    name VARCHAR(255),
    interest VARCHAR(25),
    FOREIGN KEY (facultyID) REFERENCES faculty(ID)
);

CREATE TABLE program (
    programID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    programName VARCHAR(25)
    
);

CREATE TABLE student (
    ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    FName VARCHAR(25),
    LName VARCHAR(25),
    programID INT,
    FOREIGN KEY (programID) REFERENCES program(programID)
);

CREATE TABLE student_Interests (
    studentID INT,
    interest VARCHAR(25),
    FOREIGN KEY (studentID) REFERENCES student(ID)
);

CREATE TABLE student_Contact_Info (
    studentID INT,
    phone VARCHAR(10),
    email VARCHAR(25),
    FOREIGN KEY (studentID) REFERENCES student(ID)
);

--insert some info to test the program
