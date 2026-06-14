-- Write your query below
SELECT p.project_id, e.employee_id
FROM employee e
INNER JOIN project p ON p.employee_id = e.employee_id
WHERE e.experience_years = (
    SELECT MAX(e2.experience_years)
    FROM employee e2
    JOIN project p2 ON e2.employee_id = p2.employee_id
    WHERE p2.project_id = p.project_id
);