class Solution {
    public int[] findColumnWidth(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] ans = new int[n];

        // Traverse each column
        for (int col = 0; col < n; col++) {

            int maxWidth = 0;

            // Check each row in this column
            for (int row = 0; row < m; row++) {
                int length = String.valueOf(grid[row][col]).length();
                maxWidth = Math.max(maxWidth, length);
            }

            ans[col] = maxWidth;
        }

        return ans;
    }
}
