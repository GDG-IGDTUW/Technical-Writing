class Solution {
public:
    long long largestPerimeter(vector<int>& nums) {
        //returning -1 if the no of elements is insufficient to create a polygon
        if (nums.size() < 3) return -1;


        //sorting the vector
        sort(nums.begin(), nums.end());
        int n = nums.size();
        long long Sum = 0;
        //finding sum of all elements except the largest one
        for (int i = 0; i < n-1; i++) {
            Sum += nums[i];
        }

        // Call the member function
        return Checking_Condition(Sum, nums);
    }

private:
    //creating a function that recursively checks if the sum of k-1 sides of a polygon is greater than the last side,
    //and also checks for atleast 3 elements left
    long long Checking_Condition(long long Sum, vector<int>& nums) {
        int n = nums.size();
        if (n < 3) return -1;  // Base case: too few sides

        //if condition is satisfied, return perimeter
        if (Sum > nums[n - 1]) {
            long long Last_element= nums[n-1];
            return (Sum + Last_element);
        } 
        else {
            // Remove the largest element and update sum
            long long Second_Last = nums[n-2];
            Sum-= Second_Last;    
            nums.pop_back();                
            return Checking_Condition(Sum, nums);  // recursive call
        }
    }
};
