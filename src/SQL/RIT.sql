-- drop the db if alreay there
DROP DATABASE IF EXISTS RIT;

CREATE DATABASE RIT;

CREATE TABLE faculty (
    ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    FName VARCHAR(25),
    LName VARCHAR(25),
    deptID INT
);

CREATE TABLE Faculty_Contact_Info (
    facultyID INT NOT NULL ,
    phone VARCHAR(10),
    email VARCHAR(25)
);

CREATE TABLE faculty_Interest (
    facultyID INT,
    interest VARCHAR(25)
);

CREATE TABLE student (
    ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    FName VARCHAR(25),
    LName VARCHAR(25),
    programID INT

);

CREATE TABLE student_Interests (
    studentID INT,
    interest VARCHAR(25)
);

CREATE TABLE student_Contact_Info (
    studentID INT,
    phone VARCHAR(10),
    email VARCHAR(25)
);

CREATE TABLE college (
    collegeID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    collegeName VARCHAR(25)

);

CREATE TABLE department (
    deptID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    deptName VARCHAR(25)

);

CREATE TABLE deptPhones (
    deptID INT,
    phone VARCHAR(10)
);

CREATE TABLE program (
    programID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    programName VARCHAR(25)
    
);


--insert some infor to test the program
