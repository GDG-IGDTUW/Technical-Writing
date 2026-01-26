class Solution {
public:
    int trap(vector<int>& height) {

        int n = height.size();
        int l = 0, r = n-1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;

        while (l < r) {

            if (height[l] < height[r]) {
                leftMax = max(leftMax, height[l]);
                ans += leftMax - height[l];
                l++;
            } else {
                rightMax = max(rightMax, height[r]);
                ans += rightMax - height[r];
                r--;
            }
        }

        return ans;
    }
};
