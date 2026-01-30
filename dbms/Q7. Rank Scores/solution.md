# LeetCode 178 — Rank Scores

## Problem
Table: `Scores`

| Column Name | Type    |
|------------|---------|
| id         | int     |
| score      | decimal |

- `id` is the primary key.
- Each row contains a game score.
- Scores are floating-point values with two decimal places.

### Ranking Rules
- Rank scores from **highest to lowest**
- Tied scores share the **same rank**
- Rankings must be **consecutive** (no gaps)
- Return results ordered by `score` descending

## Solution (MySQL)

```sql
SELECT
    score,
    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
FROM Scores
ORDER BY score DESC;
```
