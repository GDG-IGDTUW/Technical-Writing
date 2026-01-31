#include <stack>
#include <string>
using namespace std;

class Solution {
public:
    string simplifyPath(string path) {
        stack<string> order;
        int initial = 0;
        int index = path.find('/');

       // find() function gives string::npos when it fails, so the loop must iterate till find is able to produce output
        while (index != string::npos) {
          
            //using substr(initial_index, length_of_string) function to find the directory name from the string
            string directory = path.substr(initial, index - initial);
          
            //checking for various UNIX rules
          
            if (directory == "..") {
              // '..' is used to denote previous/parent directory: current directory is popped from the order stack
                if (!order.empty())
                    order.pop();
            } 
              
                // '.' denotes current directory and no changes are to be made
              // empty space "" denotes two consecutive slashes (//) which produce no changes in a path and are ignored
            
            else if (directory != "" && directory != ".") {
                order.push(directory);
            }

          //changing the initial to after the last element of the previous directory to find the next one
            
            initial = index + 1;
            index = path.find('/', initial);
        }
        // since this method uses a substr from initial to index, the last element in the path which does not have a succeeding '/' gets ignored. 
        // this separate function ensures the last element is not left
        string last = path.substr(initial);
        if (last == "..") {
            if (!order.empty())
                order.pop();
        } 
        else if (last != "" && last != ".") {
            order.push(last);
        }

        if (order.empty())
            return "/";

        // piecing together the final path by adding each directory name and a '/' after for the final fpath.
        string fpath;
        while (!order.empty()) {
            fpath = "/" + order.top() + fpath;
            order.pop();
        }

        return fpath;
    }
};
