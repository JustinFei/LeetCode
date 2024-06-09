# Write your MySQL query statement below
select 
    DATE_FORMAT(trans_date, '%Y-%m') as month,
    country,
    count(id) as trans_count, # COUNT(CASE WHEN state='approved' THEN amount ELSE amount END) as trans_count,
    sum(if(state = 'approved', 1, 0)) as approved_count, # COUNT(CASE WHEN state='approved' THEN amount ELSE NULL END) as approved_count,
    sum(amount) as trans_total_amount,
    sum(if(state = 'approved', amount, 0)) as approved_total_amount # SUM(CASE WHEN state='approved' THEN amount ELSE 0 END) as approved_total_amount
from Transactions
group by month, country