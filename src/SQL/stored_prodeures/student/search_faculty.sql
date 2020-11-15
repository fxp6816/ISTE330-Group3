USE `rit`;
DROP procedure IF EXISTS `search_faculty`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_faculty`(search varchar(500))
BEGIN
SELECT
	f.id as 'Faculty ID',
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
    department d ON f.departmentID = d.deptID
where
	abstracts like concat('%', search, '%');



END$$
DELIMITER ;
