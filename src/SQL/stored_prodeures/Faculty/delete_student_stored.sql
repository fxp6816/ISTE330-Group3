USE `rit`;
DROP procedure IF EXISTS `Delete Student`;



DELIMITER $$
USE `rit`$$
CREATE PROCEDURE `Delete Student` (in studentId int)
BEGIN
delete from student where id = studentId;
SELECT
	s.id as 'Student ID',
    s.fname AS 'First Name',
    s.lname AS 'Last Name',
    p.programName AS 'Program Name',
    c.phone AS 'Phone Number',
    c.email AS 'Email',
    i.interestDesc as 'Interests'
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