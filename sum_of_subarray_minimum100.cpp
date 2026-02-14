class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        int n = arr.size();
        const int MOD = 1e9 + 7;
        
        vector<int> pse(n), nse(n);
        stack<int> st;
        
        // Previous Smaller (strictly smaller)
        for(int i = 0; i < n; i++) {
            while(!st.empty() && arr[st.top()] > arr[i])
                st.pop();
                
            pse[i] = st.empty() ? -1 : st.top();
            st.push(i);
        }
        
        while(!st.empty()) st.pop();
        
        // Next Smaller (smaller or equal)
        for(int i = n-1; i >= 0; i--) {
            while(!st.empty() && arr[st.top()] >= arr[i])
                st.pop();
                
            nse[i] = st.empty() ? n : st.top();
            st.push(i);
        }
        
        long long ans = 0;
        
        for(int i = 0; i < n; i++) {
            long long left = i - pse[i];
            long long right = nse[i] - i;
            ans = (ans + arr[i] * left % MOD * right % MOD) % MOD;
        }
        
        return ans;
    }
};
