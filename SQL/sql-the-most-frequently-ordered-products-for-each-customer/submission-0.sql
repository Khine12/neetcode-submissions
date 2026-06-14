-- Write your query below
SELECT customer_id, product_id, product_name
FROM (
    SELECT o.customer_id, o.product_id, p.product_name, RANK() OVER ( PARTITION BY o.customer_id ORDER BY COUNT(*) DESC) AS rnk
    FROM orders o
    JOIN products p ON p.product_id = o.product_id
    JOIN customers c ON c.customer_id = o.customer_id
    GROUP BY o.customer_id, o.product_id, p.product_name
)temp
WHERE rnk = 1
ORDER BY customer_id, product_id;