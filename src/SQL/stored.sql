CREATE DEFINER=`root`@`localhost` PROCEDURE `Add Student`(in studentID INT)
BEGIN
insert into student (id, fname, lname, programID) values (studentID, 'Dustin', 'Rochette', 1);
insert into student_contact_info (studentID, phone, email) values ((select id from student where id=studentID), '5853959723', 'dr7210@rit.edu');
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
    program p ON s.programID = s.programID;

END