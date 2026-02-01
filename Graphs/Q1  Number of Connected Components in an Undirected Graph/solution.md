# Find Number of Connected Components using DFS

## Problem Overview

Given:

* An integer `V` representing the number of vertices (labeled `0` to `V-1`)
* A list of undirected edges `edges`

The task is to determine the **number of connected components** in the graph.

A connected component is a group of vertices such that there is a path between every pair of vertices in the group.

---

## Approach: Depth-First Search (DFS)

The solution uses **Depth-First Search (DFS)** to traverse the graph and count how many disconnected components exist.

### Key Idea

* Build an **adjacency list** from the given edges
* Maintain a `visited` array to track visited vertices
* For each unvisited vertex, run DFS to mark all vertices in its connected component
* Each DFS call represents **one connected component**

---

## Code Explanation

### DFS Function

```cpp
void dfs(int u, vector<bool>& vis, vector<vector<int>>& adj) {
    vis[u] = true;

    for (int v : adj[u]) {
        if (!vis[v]) {
            dfs(v, vis, adj);
        }
    }
}
```

**What it does:**

* Marks the current node `u` as visited
* Recursively visits all unvisited neighbors of `u`
* Ensures all nodes in the same component are visited

---

### Main Function

```cpp
int findNumberOfComponent(int V, vector<vector<int>> &edges) {
    vector<vector<int>> adj(V);
    vector<bool> vis(V, false);
    int count = 0;

    for (auto& edge : edges) {
        int u = edge[0];
        int v = edge[1];
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 0; i < V; i++) {
        if (!vis[i]) {
            dfs(i, vis, adj);
            count++;
        }
    }

    return count;
}
```

**Step-by-step:**

1. Create an adjacency list for the graph
2. Initialize a `visited` array to track visited vertices
3. Loop through all vertices:

   * If a vertex is unvisited, start DFS from it
   * Increment the component count
4. Return the total number of connected components

---

## Example

**Input:**

```
V = 5
edges = [[0,1], [1,2], [3,4]]
```

**Graph Components:**

* Component 1: `{0, 1, 2}`
* Component 2: `{3, 4}`

**Output:**

```
2
```

---

## Time and Space Complexity

* **Time Complexity:** `O(V + E)`

  * Each vertex and edge is visited once

* **Space Complexity:** `O(V + E)`

  * Adjacency list + recursion stack + visited array

---

## Summary

* DFS efficiently explores connected components
* Each DFS call corresponds to one component
* The algorithm handles disconnected graphs correctly
  
---

## BFS Approach (Alternative)
In addition to DFS, the problem can also be solved using Breadth-First Search (BFS).

### Key Idea

- Use a queue to traverse the graph level by level
- For each unvisited vertex, start BFS
- Mark all reachable vertices as visited
- Each BFS traversal corresponds to one connected component

### BFS Code
```cpp
void bfs(int start, vector<bool>& vis, vector<vector<int>>& adj) {
    queue<int> q;
    q.push(start);
    vis[start] = true;


    while (!q.empty()) {
        int u = q.front();
        q.pop();


        for (int v : adj[u]) {
            if (!vis[v]) {
                vis[v] = true;
                q.push(v);
            }
        }
    }
}
```

### Using BFS to Count Components

```cpp
int findNumberOfComponent(int V, vector<vector<int>> &edges) {
    vector<vector<int>> adj(V);
    vector<bool> vis(V, false);
    int count = 0;


    for (auto& edge : edges) {
        adj[edge[0]].push_back(edge[1]);
        adj[edge[1]].push_back(edge[0]);
    }


    for (int i = 0; i < V; i++) {
        if (!vis[i]) {
            bfs(i, vis, adj);
            count++;
        }
    }


    return count;
}
```

### Time and Space Complexity (BFS)

- Time Complexity: O(V + E)
Each vertex and edge is visited once during BFS traversal

- Space Complexity: O(V + E)
Adjacency list,
Visited array,
Queue used for BFS (can hold up to O(V) vertices)

---

### Summary

- Both DFS and BFS correctly find connected components

- DFS is simpler to write

- BFS is safer for very deep graphs

- Choice depends on constraints and preference
