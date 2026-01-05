## 21: Game Play Analysis IV

**Difficulty:** Medium  
**Tags:** sql, database, window-functions

**Problem Reference:**

* Platform: LeetCode  
* Link: https://leetcode.com/problems/game-play-analysis-iv/description/

**Concept to Read:**

* SQL window functions (`ROW_NUMBER`, `PARTITION BY`, `ORDER BY`)

**Issue Description:**

Analyze play data to find each player’s **first and second login dates** from the `Log` table.

**Acceptance Criteria:**

* Correctly identify the first login date (`first_login`) for each player  
* Correctly identify the second login date (`second_login`) for each player  
* Return `null` for players without a second login

**Bonus:**

* Use techniques like window functions (`ROW_NUMBER`) and filtering by login order
