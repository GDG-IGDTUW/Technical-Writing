class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;

        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long total = prefix[n - 1];
        int ans = 0;

        for (int i = 0; i < n - 2; i++) {
            long leftSum = prefix[i];

            int l = lowerBound(prefix, i + 1, n - 2, 2 * leftSum);
            int r = upperBound(prefix, i + 1, n - 2, (total + leftSum) / 2);

            if (l <= r) {
                ans = (ans + (r - l + 1)) % MOD;
            }
        }
        return ans;
    }

    private int lowerBound(long[] arr, int l, int r, long target) {
        int res = r + 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= target) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    private int upperBound(long[] arr, int l, int r, long target) {
        int res = l - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= target) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;   
    }
}
