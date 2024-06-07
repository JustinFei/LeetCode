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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = null;
        if (t1 == null && t2 == null) return root;
        else if (t1 == null) {
            root = new TreeNode(t2.val);
            root.left = mergeTrees(t1, t2.left);
            root.right = mergeTrees(t1, t2.right);
        }
        else if (t2 == null) {
            root = new TreeNode(t1.val);
            root.left = mergeTrees(t1.left, t2);
            root.right = mergeTrees(t1.right, t2);
        } else {
            root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        return root;
    }
}