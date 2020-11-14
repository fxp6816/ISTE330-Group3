CREATE DEFINER=`root`@`localhost` PROCEDURE `Add Student`(in studentID INT, fname varchar(25), lname varchar(25), programID int, phoneNumber varchar(25), email varchar(25))
BEGIN
insert into student (id, fname, lname, programID) values (studentID, fname, lname, programID);
insert into student_contact_info (studentID, phone, email) values ((select id from student where id=studentID), phoneNumber, email);
SELECT distinct
	s.id as 'Student ID',
    s.fname AS 'First Name',
    s.lname AS 'Last Name',
    p.programName AS 'Program Name',
    c.phone AS 'Phone Number',
    c.email AS 'Email'
FROM
    student s
        JOIN
    student_contact_info c ON c.studentID = s.id
        JOIN
    program p ON s.programID = s.programID;

END