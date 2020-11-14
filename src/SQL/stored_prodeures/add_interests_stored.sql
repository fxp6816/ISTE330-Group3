USE `rit`;
DROP procedure IF EXISTS `Add Interests`;

DELIMITER $$
USE `rit`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Add Interests`(id int, interestID int)
BEGIN
insert into student_interest (studentId, interestID) values (id, interestID);

END$$

DELIMITER ;