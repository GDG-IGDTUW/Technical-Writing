# Movie Rating

## Problem
**Platform:** LeetCode  
**Problem Link:** https://leetcode.com/problems/movie-rating/

The task is to:
1. Find the user who has rated the **most movies** (tie → lexicographically smaller name).
2. Find the movie with the **highest average rating** in **February 2020** (tie → lexicographically smaller title).

Return both results in a single column named `results`.

---

## Tables Involved

- `Users(user_id, name)`
- `Movies(movie_id, title)`
- `MovieRating(movie_id, user_id, rating, created_at)`

---

## Approach

- Use **aggregation** and **ordering** to determine top results.
- First query finds the most active user by counting ratings.
- Second query finds the highest-rated movie in February 2020 using average ratings.
- Combine both results using `UNION ALL`.

---

## SQL Solution

```sql
(SELECT name AS results
 FROM Users
 JOIN MovieRating USING(user_id)
 GROUP BY user_id
 ORDER BY COUNT(rating) DESC, name ASC
 LIMIT 1)

UNION ALL

(SELECT title AS results
 FROM Movies
 JOIN MovieRating USING(movie_id)
 WHERE created_at BETWEEN '2020-02-01' AND '2020-02-29'
 GROUP BY movie_id
 ORDER BY AVG(rating) DESC, title ASC
 LIMIT 1);
```

---
## Explanation

`COUNT(rating)` identifies the user with the most ratings.

`AVG(rating)` calculates the average movie rating.

`ORDER BY ...` ASC resolves ties lexicographically.

`UNION ALL` ensures both answers appear in the final output.
