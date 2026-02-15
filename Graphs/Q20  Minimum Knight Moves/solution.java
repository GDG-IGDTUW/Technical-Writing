import java.util.*;

class Solution {

    private static final int[][] DIRS = {
        {1, 2}, {2, 1}, {-1, 2}, {-2, 1},
        {1, -2}, {2, -1}, {-1, -2}, {-2, -1}
    };

    public int minKnightMoves(int x, int y) {

        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 0});
        visited.add("0,0");

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int cx = cur[0], cy = cur[1];

                if (cx == x && cy == y) {
                    return steps;
                }

                for (int[] d : DIRS) {
                    int nx = cx + d[0];
                    int ny = cy + d[1];

                    // Boundary pruning using symmetry
                    if (nx >= -2 && ny >= -2 &&
                        nx <= x + 2 && ny <= y + 2) {

                        String key = nx + "," + ny;

                        if (!visited.contains(key)) {
                            visited.add(key);
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
