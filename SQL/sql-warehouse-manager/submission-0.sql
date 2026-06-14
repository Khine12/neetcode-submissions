-- Write your query below
SELECT 
    w.name AS warehouse_name,
    SUM(p.width * p.length * p.height * w.units) AS volume
FROM products p
JOIN warehouse w ON w.product_id = p.product_id
GROUP BY warehouse_name;