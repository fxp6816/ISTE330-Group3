use rit;
DROP procedure IF EXISTS `add_student`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_student`(in studentID INT, fname varchar(25), lname varchar(25), programID int, phoneNumber varchar(10), email varchar(100), interestID int)
BEGIN
insert into student (id, fname, lname, programID, interestID) values (studentID, fname, lname, programID, interestID);
insert into student_contact_info (studentID, phone, email) values ((select id from student where id=studentID), phoneNumber, email);
call `add_interests` (studentID, interestID);
SELECT
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
    program p ON s.programID = p.programID
        join
    interests i on s.interestID = i.interestID;

END$$
DELIMITER ;
