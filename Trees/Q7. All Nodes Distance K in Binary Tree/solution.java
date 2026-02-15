import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // Step 1: Build parent map
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParentMap(root, null, parent);

        // Step 2: BFS from target
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            if (distance == k) break;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // left child
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                // right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }

                // parent
                TreeNode p = parent.get(node);
                if (p != null && !visited.contains(p)) {
                    visited.add(p);
                    queue.offer(p);
                }
            }

            distance++;
        }

        // Step 3: collect results
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode par,
                                Map<TreeNode, TreeNode> parent) {
        if (node == null) return;

        parent.put(node, par);

        buildParentMap(node.left, node, parent);
        buildParentMap(node.right, node, parent);
    }
}
