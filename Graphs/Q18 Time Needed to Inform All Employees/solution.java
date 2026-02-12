class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                tree[manager[i]].add(i);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{headID, 0});

        int result = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int time = curr[1];

            result = Math.max(result, time);

            for (int child : tree[node]) {
                queue.offer(new int[]{child, time + informTime[node]});
            }
        }

        return result;
        
    }
}
