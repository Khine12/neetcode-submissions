-- Write your query below
SELECT c.customer_id, c.name
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN product p ON o.product_id = p.product_id
WHERE o.order_date >= '2020-06-01' AND o.order_date < '2020-08-01'
GROUP BY c.customer_id, c.name
HAVING 
    SUM(CASE WHEN o.order_date >= '2020-06-01' AND o.order_date < '2020-07-01' THEN p.price* o.quantity ELSE 0 END) >= 100 
    AND SUM (CASE WHEN o.order_date >= '2020-07-01' AND o.order_date < '2020-08-01' THEN p.price * o.quantity ELSE 0 END) >= 100;