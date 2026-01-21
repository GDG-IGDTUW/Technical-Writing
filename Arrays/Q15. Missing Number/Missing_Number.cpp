class Solution {
public:
    int missingNumber(vector<int>& nums) {
        //defining the length of the array
        int n= nums.size();
        //sum of first n natural numbers is given by:
        int sum = (n*(n+1))/2;
        //finding sum of elements in the array
        int arrsum=0;
        for(int i=0; i<n; i++){
            arrsum+= nums[i];
        }   
    //comparing total sum and sum of array to find missing number
    return (sum-arrsum);
    }
    
};
