-- Write your query below
SELECT actor_id, director_id
FROM actor_director
GROUP BY actor_id, director_id
HAVING COUNT(*) >= 3;