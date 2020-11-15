USE `rit`;
DROP procedure IF EXISTS `add_faculty`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_faculty`(facultyID int, fname varchar(25), lname varchar(25), abstracts varchar(2000), phoneNumber varchar(10), email varchar(100), officeHours varchar(255), officeNumber varchar(255), departmentID int)
BEGIN
insert into faculty (ID, fname, lname, abstracts, departmentID) values (facultyID, fname, lname, abstracts, departmentID);
insert into faculty_contact_info values ((select id from faculty where id=facultyID), phoneNumber, email, officeHours, officeNumber);
SELECT
	f.id as 'Student ID',
    f.fname AS 'First Name',
    f.lname AS 'Last Name',
    d.deptName AS 'Department Name',
    fc.phone AS 'Phone Number',
    fc.email AS 'Email',
    fc.officeHours as 'Office Hours',
    fc.officeNumber as 'Office Number'    
FROM
    faculty f
        JOIN
    faculty_contact_info fc ON fc.facultyID = f.id
        JOIN
    department d ON f.departmentID = d.deptID;

END$$
DELIMITER ;
