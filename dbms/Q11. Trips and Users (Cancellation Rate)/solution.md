# Solution: Trips and Users (Cancellation Rate)

**Approach**

To calculate the daily cancellation rate, we need to:
1. Exclude banned users
- Both clients and drivers must have banned = 'No'.
- This is handled using JOIN conditions with the Users table.

2. Define the denominator correctly (Total Trips)
- The denominator should include all valid trips (completed + cancelled) for non-banned users on a given day.
- This is achieved using COUNT(*) after filtering.

3. Identify cancelled trips (Numerator)
- Any trip whose status != 'completed' is considered cancelled.
- We count these using a CASE expression inside SUM().

4. Group by day
- The cancellation rate is calculated per day, so we group by request_at.

5. Round the result
- The final cancellation rate is rounded to 2 decimal places using ROUND().

**SQL Solution**
```sql
SELECT 
    t.request_at AS Day,
    ROUND(
        SUM(
            CASE 
                WHEN t.status != 'completed' THEN 1
                ELSE 0
            END
        ) / COUNT(*),
        2
    ) AS "Cancellation Rate"
FROM Trips t
JOIN Users c 
    ON t.client_id = c.users_id 
    AND c.banned = 'No'
JOIN Users d 
    ON t.driver_id = d.users_id 
    AND d.banned = 'No'
WHERE t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY t.request_at;
```

**Explanation of Denominator (Bonus)**

The denominator is COUNT(*), which represents:
- The total number of trips on that day after excluding banned clients and drivers.
This is important because:
- Using all trips (instead of only completed ones) ensures the cancellation rate reflects the true proportion of cancelled trips.
- Filtering banned users before counting avoids inflating or skewing the rate.
