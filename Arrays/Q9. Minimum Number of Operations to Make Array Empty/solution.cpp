class Solution {
public:
    int minOperations(vector<int>& nums) {
        unordered_map<int,int> mp;

        for(int i:nums){
            mp[i]++;
        }

        int ops=0;

        for(auto [num,f]:mp){
            if(f==1){
                return -1;
            }
            ops+=(f+2)/3;
        }

        return ops;
    }
};
