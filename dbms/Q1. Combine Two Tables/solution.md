# 175. Combine Two Tables

---

## Intuition

We are given two tables:

* **Person**: contains basic information about each person (first name, last name).
* **Address**: contains address details (city, state) linked to a person via `personId`.

Our goal is to return **all people**, along with their address **if it exists**.

Key observation:

* Some people **may not have an address** in the `Address` table.
* We still need to include them in the result, filling `city` and `state` with `NULL`.

This is a classic use case for a **LEFT JOIN**:

* Start from the `Person` table.
* Join the `Address` table on `personId`.
* A `LEFT JOIN` ensures that every person appears in the output, even if no matching address is found.

---

## SQL Solution

```sql
SELECT
    p.firstName,
    p.lastName,
    a.city,
    a.state
FROM Person p
LEFT JOIN Address a
    ON p.personId = a.personId;
```

---

## ⏱️ Complexity

* **Time Complexity:** O(n + m) where `n` is rows in `Person`, `m` in `Address`
* **Space Complexity:** O(1) (excluding output)

---
