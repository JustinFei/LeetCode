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
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 2 + root.val;
        // only if root.left == null && root.right == null, can root.left == root.right
        return root.left == root.right ? val : dfs(root.left, val) + dfs(root.right, val);
    }
}