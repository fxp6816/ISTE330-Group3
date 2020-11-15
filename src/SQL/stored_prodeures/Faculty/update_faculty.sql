use rit;

DROP procedure IF EXISTS `update_faculty`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_faculty`(facultyID int, fName varchar(25), lName varchar(25), abstracts varchar(2000), phoneNumber varchar(10), email varchar(100), officeHours varchar(255), officeNumber varchar(255), departmentID int)
BEGIN
call `delete_faculty` (facultyID);
call `add_faculty` (facultyID, fName, lName, abstracts, phoneNumber, email, officeHours, officeNumber, departmentID);
END$$
DELIMITER ;
