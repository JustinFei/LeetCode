# Write your MySQL query statement below
SELECT w1.id
FROM Weather AS w1 , Weather AS w2
WHERE w1.Temperature > w2.Temperature AND DATEDIFF(w1.recordDate , w2.recordDate) = 1

##################################################################################

# Write your MySQL query statement below
SELECT t1.Id
FROM Weather t1, Weather t2
WHERE t1.Temperature > t2.Temperature AND
    TO_DAYS(t1.DATE)-TO_DAYS(t2.DATE)=1;