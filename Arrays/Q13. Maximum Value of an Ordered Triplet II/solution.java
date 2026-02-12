class Solution {
    public long maximumTripletValue(int[] nums) {

        int n = nums.length;

        // Step 1: suffix max array
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(nums[i], suffixMax[i + 1]);
        }

        long maxValue = 0;
        int prefixMax = nums[0];

        // Step 2: try each j as middle index
        for (int j = 1; j < n - 1; j++) {

            long value = (long) (prefixMax - nums[j]) * suffixMax[j + 1];
            maxValue = Math.max(maxValue, value);

            // update prefix max
            prefixMax = Math.max(prefixMax, nums[j]);
        }

        return maxValue;
    }
}
