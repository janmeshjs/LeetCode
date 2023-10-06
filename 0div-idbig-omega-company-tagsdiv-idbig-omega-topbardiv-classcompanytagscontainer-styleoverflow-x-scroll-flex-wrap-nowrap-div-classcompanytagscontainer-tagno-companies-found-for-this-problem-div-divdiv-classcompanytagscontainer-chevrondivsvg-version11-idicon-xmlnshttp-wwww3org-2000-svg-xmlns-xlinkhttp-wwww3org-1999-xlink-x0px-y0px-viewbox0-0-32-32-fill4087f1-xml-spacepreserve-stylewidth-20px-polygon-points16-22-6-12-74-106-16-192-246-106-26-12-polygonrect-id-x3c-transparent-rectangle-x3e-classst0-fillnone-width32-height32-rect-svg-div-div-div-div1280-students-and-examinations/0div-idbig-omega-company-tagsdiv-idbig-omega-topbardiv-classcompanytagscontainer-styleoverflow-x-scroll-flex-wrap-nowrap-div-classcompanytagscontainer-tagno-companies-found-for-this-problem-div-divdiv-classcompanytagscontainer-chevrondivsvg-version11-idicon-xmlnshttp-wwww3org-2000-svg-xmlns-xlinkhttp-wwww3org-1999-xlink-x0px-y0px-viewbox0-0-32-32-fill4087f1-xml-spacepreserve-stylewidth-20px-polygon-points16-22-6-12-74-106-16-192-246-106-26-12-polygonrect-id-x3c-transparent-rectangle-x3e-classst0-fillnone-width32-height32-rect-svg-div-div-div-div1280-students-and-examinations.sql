select 
  t.student_id, 
  t.student_name, 
  t.subject_name, 
  count(e.student_id) as attended_exams 
from 
  (
    select 
      s.student_id, 
      s.student_name, 
      sj.subject_name 
    from 
      Students s, 
      Subjects sj
  ) t 
  left join Examinations e on e.student_id = t.student_id 
  and e.subject_name = t.subject_name 
group by 
  t.student_id, 
  t.student_name, 
  t.subject_name 
order by 
  t.student_id, 
  t.subject_name;