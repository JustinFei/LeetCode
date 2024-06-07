/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] res = { 0 };
        helper(root, res);
        return res[0];
    }
    
    private int helper(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        res[0] = Math.max(left + right, res[0]);
        return Math.max(left, right) + 1;
    }
}