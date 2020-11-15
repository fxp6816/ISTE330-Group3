USE `rit`;
DROP procedure IF EXISTS `add_interests`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_interests`(id int, interestID int)
BEGIN
insert into student_interest (studentId, interestID) values (id, interestID);

END$$
DELIMITER ;
