# Write your MySQL query statement below
SELECT Department.Name AS Department, emp1.Name AS Employee, emp1.Salary AS Salary
FROM Employee emp1 join Department on emp1.DepartmentId = Department.Id
WHERE emp1.Salary = (SELECT Max(Salary) FROM Employee emp2 WHERE emp2.DepartmentId = emp1.DepartmentId);