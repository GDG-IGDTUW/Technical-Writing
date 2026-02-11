#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findTheDistanceValue(vector<int>& arr1, vector<int>& arr2, int d) {
        
        sort(arr2.begin(), arr2.end());  // Step 1: Sort arr2
        int count = 0;

        for(int num : arr1) {
            
            // Binary search to find lower bound
            auto it = lower_bound(arr2.begin(), arr2.end(), num);
            
            bool valid = true;

            // Check right neighbor
            if(it != arr2.end() && abs(*it - num) <= d)
                valid = false;

            // Check left neighbor
            if(it != arr2.begin()) {
                it--;
                if(abs(*it - num) <= d)
                    valid = false;
            }

            if(valid) count++;
        }

        return count;
    }
};
