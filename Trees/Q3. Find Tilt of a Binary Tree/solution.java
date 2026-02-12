/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    // Must be declared at class level
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return totalTilt;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        totalTilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + node.val;
    }
}
