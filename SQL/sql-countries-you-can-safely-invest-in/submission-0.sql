-- Write your query below
SELECT c.name AS country
FROM country c
JOIN person p ON SUBSTRING(p.phone_number,1,3) = c.country_code 
JOIN calls ca ON p.id = ca.caller_id OR p.id = ca.callee_id
GROUP BY c.name
HAVING AVG(ca.duration) > (SELECT AVG(duration) FROM calls);