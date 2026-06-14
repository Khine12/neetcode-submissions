-- Write your query below
SELECT u.name, SUM(t.amount) AS balance
FROM users u
JOIN transactions t ON u.account = t.account
GROUP BY u.account
HAVING SUM(t.amount) > 10000;