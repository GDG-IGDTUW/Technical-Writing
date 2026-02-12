class Solution {

    public int makeConnected(int n, int[][] connections) {

        // Step 1: Not enough cables
        if (connections.length < n - 1) {
            return -1;
        }

        UnionFind uf = new UnionFind(n);

        // Step 2: Connect components
        for (int[] c : connections) {
            uf.union(c[0], c[1]);
        }

        // Step 3: Count components
        return uf.getComponents() - 1;
    }

    // ===== Union Find =====
    class UnionFind {
        int[] parent;
        int components;

        UnionFind(int n) {
            parent = new int[n];
            components = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px != py) {
                parent[px] = py;
                components--;
            }
        }

        int getComponents() {
            return components;
        }
    }
}
