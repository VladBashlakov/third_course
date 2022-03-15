SELECT*FROM student

         INNER JOIN faculty ON student.faculty_id = faculty.id
         RIGHT JOIN avatar ON student.id = avatar.student_id

