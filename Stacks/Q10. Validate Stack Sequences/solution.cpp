class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int>s;
        int i=0,j=0;
        while(i<pushed.size()){
            s.push(pushed[i]);
            i++;
            while(!s.empty() && s.top()==popped[j]){
                s.pop();
                j++;
            }

        }

        return s.size()==0;
        
    }
};
