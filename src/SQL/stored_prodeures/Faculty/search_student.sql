USE `rit`;
DROP procedure IF EXISTS `search_student`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_student`(interestID int)
BEGIN
select distinct
	s.fName, s.lName, sc.phone, sc.email, i.interestDesc from student_interest si
	join interests i on interestID = i.interestID
    join student s on si.studentID = s.id
    join student_contact_info sc on si.studentID = sc.studentID
    where si.interestID = interestID;
END$$
DELIMITER ;
