# Write your MySQL query statement below
select s.student_id, s.student_name, k.subject_name, COUNT(e.student_id) AS attended_exams
from Students s
cross join Subjects k
left join Examinations e on s.student_id = e.student_id and k.subject_name = e.subject_name
group by s.student_id, s.student_name, k.subject_name
order by s.student_id, k.subject_name;

##############################################

SELECT s.student_id, s.student_name, sub.subject_name, COALESCE(e.attended_exams, 0) AS attended_exams
FROM Students s
CROSS JOIN Subjects sub
LEFT JOIN (
    SELECT student_id, subject_name, COUNT(*) AS attended_exams
    FROM Examinations
    GROUP BY student_id, subject_name
) e 
ON s.student_id = e.student_id AND sub.subject_name = e.subject_name # USING (student_id, subject_name)
ORDER BY s.student_id, sub.subject_name;

