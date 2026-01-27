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
class Solution {
public:
TreeNode* first=NULL;
TreeNode* second=NULL;
TreeNode* prev=NULL;

void inOrder(TreeNode* root) {

    if(root==NULL) return;

    inOrder(root->left);

    if(prev and prev->val > root->val) { // violation
        if(first==NULL) first = prev;
        second = root;
    }
    prev = root;

    inOrder(root->right);
}
    void recoverTree(TreeNode* root) {
        inOrder(root);
        swap(first->val,second->val);
    }
};
