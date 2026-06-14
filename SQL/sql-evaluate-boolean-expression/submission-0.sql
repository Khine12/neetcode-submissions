-- Write your query below
SELECT 
    e.left_operand, 
    e.operator, 
    e.right_operand,
    CASE 
        WHEN e.operator = '>' AND e.left_operand > e.right_operand THEN 'true'
        WHEN e.operator = '<' AND e.left_operand < e.right_operand THEN 'true'
        WHEN e.operator = '=' AND e.left_operand = e.right_operand THEN 'true'
        ELSE 'false'
        END AS value

FROM expressions e
JOIN variables lv ON e.left_operand = lv.name
JOIN variables rv ON e.right_operand = rv.name;