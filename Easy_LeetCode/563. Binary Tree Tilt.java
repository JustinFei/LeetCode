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
    public int findTilt(TreeNode root) {
        int[] tilt = { 0 };
        postOrder(root, tilt);
        return tilt[0];
    }
    
    private int postOrder(TreeNode root, int[] tilt) {
        if (root == null) return 0;
        int left = postOrder(root.left, tilt);
        int right = postOrder(root.right, tilt);
        tilt[0] += Math.abs(left - right);
        return left + right + root.val;
    }
}