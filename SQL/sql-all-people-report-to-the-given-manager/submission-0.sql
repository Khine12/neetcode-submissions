-- Write your query below
SELECT e1.employee_id
FROM employees e1
JOIN employees e2 ON e2.employee_id = e1.manager_id
LEFT JOIN employees e3 ON e3.employee_id = e2.manager_id
LEFT JOIN employees e4 ON e4.employee_id = e3.manager_id
WHERE e1.employee_id != 1 AND (

    e1.manager_id = 1 OR e2.manager_id = 1 OR e3.manager_id = 1
);