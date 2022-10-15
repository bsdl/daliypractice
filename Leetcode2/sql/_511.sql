# Write your MySQL query statement below
select 
player_id, Min(event_date) first_login 
from 
Activity 
group by 
player_id;
