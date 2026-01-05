## 17: Customer Who Visited but Did Not Make Any Transactions

**Difficulty:** Easy  
**Tags:** sql, database, join

**Problem Reference:**

* Platform: LeetCode  
* Link: https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/description/

**Concept to Read:**

* SQL JOIN and aggregation

**Issue Description:**

Find customers who **visited the store** but **did not make any transactions**.

**Acceptance Criteria:**

* Correctly identifies customers present in `Visits` but not in `Transactions`  
* Returns only customer IDs with no corresponding transactions  

**Bonus:**

* Solve using `LEFT JOIN` with `IS NULL` and `NOT EXISTS`
