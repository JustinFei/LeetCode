# Write your MySQL query statement below
SELECT E1.Name as Employee
FROM Employee as E1, Employee as E2 
WHERE E1.ManagerId = E2.Id and E1.Salary > E2.Salary