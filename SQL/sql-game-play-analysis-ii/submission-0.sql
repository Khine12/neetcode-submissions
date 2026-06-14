-- Write your query below
SELECT a.player_id, a.device_id
FROM activity a
INNER JOIN(
    SELECT player_id,MIN(event_date) AS first_login
    FROM activity
    GROUP BY player_id
) first_logins ON a.player_id = first_logins.player_id AND a.event_date = first_logins.first_login; 