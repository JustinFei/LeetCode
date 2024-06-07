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
    long total = 0;
    long ans = 0;
    long cur;
    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        total = dfs(root);
        dfs(root);
        return (int) (ans % (1e9+7));   
    }
    
    private long dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        cur = root.val + dfs(root.left) + dfs(root.right);
        ans = Math.max(ans, (total - cur) * cur);
        return cur;
    }
}