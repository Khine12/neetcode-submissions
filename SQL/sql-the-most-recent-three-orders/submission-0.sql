-- Write your query below
SELECT 
    c.name AS customer_name,
    c.customer_id,
    o.order_id,
    o.order_date
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
WHERE (
    SELECT COUNT(*)
    FROM orders o2
    WHERE o2.customer_id = o.customer_id AND o2.order_date > o.order_date
) < 3
ORDER BY c.name ASC, c.customer_id ASC, o.order_date DESC;