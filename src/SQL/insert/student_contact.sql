insert into student_contact_info (studentID, phone, email) values ((select id from student where id='1'), '5853959723', 'dr7210@rit.edu');

SELECT 
    s.fname as "First Name",
    s.lname as "Last Name",
    p.programName as "Program Name",
    c.phone as "Phone Number",
    c.email as "Email"
FROM
    student s
		JOIN
    student_contact_info c ON c.studentID = s.id
		join
	program p on s.programID = s.programID;