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
    long ans = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

    private void dfs(TreeNode node, int min) {
        if (node == null)
            return;

        if (node.val > min) {
            ans = Math.min(ans, node.val);
            return;
        }

        dfs(node.left, min);
        dfs(node.right, min);
    }
}