use rit;
DROP procedure IF EXISTS `delete_student`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_student`(in id int)
BEGIN
delete from student_contact_info where studentID = id;
delete from student where id = id;
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
END$$
DELIMITER ;
