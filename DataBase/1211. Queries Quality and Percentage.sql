# Write your MySQL query statement below
select query_name,
    round(avg(rating / position), 2) as quality, #(cast(rating as decimal)
    round(sum(if(rating < 3, 1, 0)) * 100 / count(*), 2) as poor_query_percentage # sum(case when rating < 3 then 1 else 0 end)
from queries
WHERE query_name IS NOT NULL
group by query_name