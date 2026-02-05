## Solution Approach

1. **Convert friend requests into bidirectional relationships**.  
   - Each row `(requester_id, accepter_id)` creates **two entries**: one for the requester and one for the accepter.  

2. **Count friends per user** using `GROUP BY`.  

3. **Select the person with the maximum number of friends**.  

This can be done efficiently using a **UNION ALL** to generate bidirectional pairs.

---

## SQL Solution

```sql
WITH AllFriends AS (
    SELECT requester_id AS id, accepter_id AS friend_id
    FROM RequestAccepted
    UNION ALL
    SELECT accepter_id AS id, requester_id AS friend_id
    FROM RequestAccepted
)
SELECT id, COUNT(friend_id) AS num
FROM AllFriends
GROUP BY id
ORDER BY num DESC
LIMIT 1;
```

## Explanation:

- UNION ALL duplicates the friendships so that each friendship is counted for both users.

- GROUP BY id counts the number of friends per person.

- ORDER BY num DESC LIMIT 1 retrieves the person with the most friends.
