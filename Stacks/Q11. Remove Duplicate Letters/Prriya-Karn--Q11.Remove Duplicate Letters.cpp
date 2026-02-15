class Solution {
public:
    string removeDuplicateLetters(string s) {
        stack<char> st;
        vector<bool> hash(26,false);
        vector<int> lastInd(26,0);
        string res;

        for(int i=0;i<s.size();i++){
            lastInd[s[i] - 'a'] = i; 
        }

        for(int i=0;i<s.size();i++){
            while(!st.empty() && st.top() > s[i] && hash[s[i] - 'a'] == false && lastInd[st.top() - 'a']>i){
                hash[st.top() - 'a'] = false;
                st.pop();
            }

if(hash[s[i] - 'a'] == false){
     st.push(s[i]);
      hash[s[i] - 'a'] = true;
}
           
        }


        while(!st.empty()){
            res.push_back(st.top());
            st.pop();
        }

        reverse(res.begin(),res.end());


        return res;
        

    }
};