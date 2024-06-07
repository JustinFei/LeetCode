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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left != null || root.right != null) {
            TreeNode cur = root.left;
            root.left = root.right;
            root.right = cur;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}