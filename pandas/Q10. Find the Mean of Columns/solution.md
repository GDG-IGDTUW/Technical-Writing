## Problem
Given a pandas DataFrame scores containing id and score.

To do: Write a solution to determine the rank of each score based on the following rules:
- The scores should be ranked from highest to lowest.
- If there is a tie between two scores, both should have the same rank.
- After a tie, the next rank number should be the next consecutive integer (i.e., no gaps in ranking). This is known as "dense ranking".

---

## Solution
Use pandas .rank(method='dense', ascending=False) for optimal dense ranking.

### Python Implementation
```python
import pandas as pd
def orderScores(scores: pd.DataFrame) -> pd.DataFrame:
    scores['rank'] = scores['score'].rank(method='dense', ascending=False)
    return scores.sort_values('score', ascending=False)[['score', 'rank']]
```

Explanation
- method='dense': Ties share rank, no gaps after ties
- ascending=False: Highest score gets rank 1
- [['score', 'rank']]: Exact output columns required

