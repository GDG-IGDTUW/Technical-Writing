/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Triple {
    public:
    int numOfCameras;
    bool isCovered;
    bool hasCamera;
};

class Solution {
public:

Triple dfs(TreeNode*root) {
    Triple t;

    // base case

    if(root==NULL) {
        t.numOfCameras=0;
        t.hasCamera=false;
        t.isCovered=true;
        return t;
    }

    // recursive case

    Triple left=dfs(root->left);
    Triple right=dfs(root->right);

    // decide for the root node

    if(!left.isCovered or !right.isCovered) {
        // install a camera at the root node

        t.numOfCameras=left.numOfCameras+right.numOfCameras+1;
        t.isCovered=true;
        t.hasCamera=true;

    } else {
        // both are covered, so dont install the camera at root node

        t.numOfCameras=left.numOfCameras+right.numOfCameras;
        t.isCovered=left.hasCamera or right.hasCamera ? true : false;
        t.hasCamera=false;
    }
    return t;

}
    int minCameraCover(TreeNode* root) {
        Triple t=dfs(root);
        if(t.isCovered==false) {
            return t.numOfCameras + 1;
        }
        return t.numOfCameras;
    }
};
