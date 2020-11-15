USE `rit`;
DROP procedure IF EXISTS `update_student`;

DELIMITER $$
USE `rit`$$
CREATE PROCEDURE `update_student` (studentId int, fName varchar(25), lName varchar(25), programID int, phoneNumber varchar(10), email varchar(100), interestID int)
BEGIN
call `delete_student` (studentID);
call `add_student` (studentID, fName, lName, programID, phoneNumber, email, interestID);
END$$

DELIMITER ;