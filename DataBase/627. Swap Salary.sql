# Write your MySQL query statement below
UPDATE salary
SET sex = ( CASE WHEN sex = 'M'
          THEN 'f'
          ELSE 'm'
          END)