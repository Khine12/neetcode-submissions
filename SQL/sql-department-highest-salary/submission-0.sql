-- Write your query below
SELECT d.name AS department,
       e.name AS employee,
       e.salary
FROM department d
JOIN employee e ON e.department_id = d.id
WHERE e.salary = (
    SELECT MAX(e2.salary)
    FROM employee e2
    WHERE e2.department_id = e.department_id
)
GROUP BY d.name,e.name,e.salary;