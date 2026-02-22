## Goal

Swap the seat IDs of every two consecutive students.

### Rules:

- Swap:
  - 1 ↔ 2
  - 3 ↔ 4
  - 5 ↔ 6
  - ...

- If total number of students is **odd**, the last student remains unchanged.

Return the result ordered by `id`.

---

## Approach

We reassign IDs using logic:

- If `id` is **odd** → swap with next → `id + 1`
- If `id` is **even** → swap with previous → `id - 1`
- If `id` is the **last odd id** → keep same

To detect last row, compare with total count.

---

## SQL Solution

```sql
SELECT
    CASE
        WHEN id % 2 = 1 AND id = (SELECT MAX(id) FROM Seat) THEN id
        WHEN id % 2 = 1 THEN id + 1
        ELSE id - 1
    END AS id,
    student
FROM Seat
ORDER BY id;
```
---

## Complexity

- Time: O(N)

- Space: O(1)
