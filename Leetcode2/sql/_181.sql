# Write your MySQL query statement below
select e1.name Employee
from Employee e1, Employee e2 
where 
e1.managerId = e2.id 
and 
e1.salary > e2.salary;