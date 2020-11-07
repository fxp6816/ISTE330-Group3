-- drop the db if alreay there
DROP DATABASE IF EXISTS RIT;

CREATE DATABASE RIT;

CREATE TABLE faculty VALUES(
    ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    FName VARCHAR(25),
    LName VARCHAR(25),
    deptID INT ,
    
);

CREATE TABLE facultyContactInfo VALUES(
    facultyID INT NOT NULL ,
    phone VARCHAR(10),
    email VARCHAR(25)
);

CREATE TABLE facultyInterest VALUES(
    facultyID INT,
    interest VARCHAR(25)
);

CREATE TABLE student VALUES(
    ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    FName VARCHAR(25),
    LName VARCHAR(25),
    programID INT ,
    
);

CREATE TABLE studentInterests VALUES(
    studentID INT,
    interest VARCHAR(25)
);
CREATE TABLE studentContactInfo VALUES(
    studentID INT,
    phone VARCHAR(10),
    email VARCHAR(25)
);

CREATE TABLE collage VALUES(
    collageID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    colalgeName VARCHAR(25)
    
);
CREATE TABLE department VALUES(
    deptID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    deptName VARCHAR(25)
    
);
CREATE TABLE deptPhones VALUES(
    deptID INT,
    phone VARCHAR(10)
);

CREATE TABLE program VALUES(
    programID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    programName VARCHAR(25)
    
);


--insert some infor to test the program