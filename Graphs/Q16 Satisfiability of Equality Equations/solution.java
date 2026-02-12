class Solution {

    public boolean equationsPossible(String[] equations) {

        UnionFind uf = new UnionFind(26);

        // Step 1: process all equalities
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                uf.union(x, y);
            }
        }

        // Step 2: check inequalities
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';

                if (uf.find(x) == uf.find(y)) {
                    return false; // contradiction
                }
            }
        }

        return true;
    }

    // ===== Union Find =====
    class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
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
            if (px != py) parent[px] = py;
        }
    }
}
