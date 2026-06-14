-- Write your query below
SELECT transaction_id
FROM transactions
WHERE (DATE(day),amount) IN (
    SELECT DATE(day),MAX(amount)
    FROM transactions
    GROUP BY DATE(day)
)
ORDER BY transaction_id ASC;