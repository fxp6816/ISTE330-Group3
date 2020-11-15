USE `rit`;
DROP procedure IF EXISTS `delete_faculty`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_faculty`(in facultyId int)
BEGIN
delete from faculty where id = facultyId;
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
