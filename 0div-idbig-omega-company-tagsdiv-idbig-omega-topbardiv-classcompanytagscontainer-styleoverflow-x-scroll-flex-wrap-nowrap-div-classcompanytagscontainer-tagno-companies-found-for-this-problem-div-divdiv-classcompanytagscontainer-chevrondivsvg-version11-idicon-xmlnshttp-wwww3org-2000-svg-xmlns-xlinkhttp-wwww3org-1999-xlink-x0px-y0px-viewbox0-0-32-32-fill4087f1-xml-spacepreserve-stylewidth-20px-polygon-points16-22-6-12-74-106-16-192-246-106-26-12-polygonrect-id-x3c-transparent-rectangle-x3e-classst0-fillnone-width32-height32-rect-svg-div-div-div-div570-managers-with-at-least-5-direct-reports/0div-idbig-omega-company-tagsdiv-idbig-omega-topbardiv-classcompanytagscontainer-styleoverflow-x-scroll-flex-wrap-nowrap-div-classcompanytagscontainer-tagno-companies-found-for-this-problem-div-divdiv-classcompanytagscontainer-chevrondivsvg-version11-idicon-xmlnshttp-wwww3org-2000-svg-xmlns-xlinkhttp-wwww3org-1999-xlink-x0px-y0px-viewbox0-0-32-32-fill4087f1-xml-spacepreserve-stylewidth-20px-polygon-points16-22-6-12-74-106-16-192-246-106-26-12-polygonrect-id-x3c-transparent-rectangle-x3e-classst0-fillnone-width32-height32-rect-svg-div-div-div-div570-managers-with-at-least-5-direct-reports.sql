select e.name
from Employee e
join Employee j on e.id = j.managerId
group by j.managerId
having count(j.managerId) >=5