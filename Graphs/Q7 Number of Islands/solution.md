# Number of Islands (DFS Approach)

This code solves the **Number of Islands** problem using **Depth-First Search (DFS)**.  
It is a common interview problem that tests your understanding of **graph traversal** and **matrix manipulation**.

---

## Problem Statement

Given a 2D grid of `'1'`s (land) and `'0'`s (water), count the number of islands.  
An **island** is surrounded by water and is formed by connecting adjacent lands **horizontally or vertically**.

---

## Approach

We can solve this problem using **DFS**. The idea is:

1. Traverse the entire grid.
2. When a `'1'` is found, it marks the **start of an island**.
3. Use DFS to **mark all connected land cells** (`'1'`) as `'0'` to avoid counting them again.
4. Increment the island count each time a new DFS starts.

---

## Code

```cpp
void dfs(int i, int j, vector<vector<char>>& grid, int n, int m) {
    // Mark current cell as visited
    grid[i][j] = '0';

    // Directions: up, right, down, left
    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};

    for(int d = 0; d < 4; d++) {
        int nx = i + dx[d];
        int ny = j + dy[d];

        // Check boundaries and if the cell is land
        if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '1') {
            dfs(nx, ny, grid, n, m);
        }
    }
}

int numIslands(vector<vector<char>>& grid) {
    int n = grid.size();
    int m = grid[0].size();
    int count = 0;

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(grid[i][j] == '1') {
                dfs(i, j, grid, n, m);
                count++;
            }
        }
    }

    return count;
}
```

---

## Complexity Analysis
- Time Complexity: O(n * m) as each cell is visited at most once
- Space Complexity: O(n * m) in the worst case (recursion stack for DFS).
