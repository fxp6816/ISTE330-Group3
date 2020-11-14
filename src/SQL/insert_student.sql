delimiter //

CREATE PROCEDURE `Add Student` @studentID nvarchar(50)
BEGIN
insert into student (@studentID, 'Dustin', 'Rochette', 1);
insert into student_contact_info (studentID, phone, email) values ((select id from student where id=@studentID), '5853959723', 'dr7210@rit.edu');
select * from student;
END //

delimiter ;