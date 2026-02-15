// Course Schedule II

/**
PROBLEM SUMMARY:
You are given numCourses labeled from 0 to numCourses-1 and a list of
prerequisites, where prerequisites[i] = {a, b} means you must take
course b before course a.

Return an ordering of courses you can take to finish all courses.
If it is impossible (cycle exists), return an empty vector.

------------------------------------------------------------
INTUITION:
This is a classic topological sorting problem on a directed graph.

- Each course is a node
- A prerequisite (b -> a) is a directed edge
- We want a linear ordering such that every edge goes left to right

If the graph has a cycle, no valid ordering exists.

We use Kahn’s Algorithm (BFS-based topological sort):
1. Count indegrees (number of prerequisites) for each course
2. Start with courses that have indegree 0
3. Repeatedly take such courses and reduce indegrees of neighbors

If we can process all courses → valid order
If not → cycle exists

------------------------------------------------------------
ALGORITHM:
1. Build adjacency list and indegree array
2. Push all nodes with indegree 0 into a queue
3. While queue is not empty:
   - Pop a course
   - Add it to result
   - Reduce indegree of dependent courses
   - If any becomes 0, push into queue
4. If result size == numCourses, return result
   Else return empty vector

------------------------------------------------------------
TIME COMPLEXITY:
O(V + E)
V = number of courses
E = number of prerequisites

SPACE COMPLEXITY:
O(V + E) for graph and indegree storage
**/

class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        // Adjacency list: graph[b] contains all courses that depend on b
        vector<vector<int>> graph(numCourses);

        // indegree[i] = number of prerequisites for course i
        vector<int> indegree(numCourses, 0);

        // Build the graph
        for (auto &p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph[prereq].push_back(course);
            indegree[course]++;
        }

        // Queue for courses with no prerequisites
        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }

        vector<int> order;

        // Kahn's Algorithm
        while (!q.empty()) {
            int curr = q.front();
            q.pop();
            order.push_back(curr);

            // Reduce indegree of neighbors
            for (int next : graph[curr]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.push(next);
                }
            }
        }

        // If we were able to take all courses, return the order
        if ((int)order.size() == numCourses) {
            return order;
        }

        // Cycle detected → impossible to finish all courses
        return {};
    }
};
