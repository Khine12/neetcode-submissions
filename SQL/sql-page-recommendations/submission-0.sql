-- Write your query below
SELECT DISTINCT l.page_id AS recommended_page
FROM likes l
JOIN friendship f ON (f.user1_id = 1 AND f.user2_id =  l.user_id) OR (f.user2_id = 1 AND f.user1_id = l.user_id)
WHERE l.page_id NOT IN(
    SELECT page_id
    FROM likes
    WHERE user_id = 1
);