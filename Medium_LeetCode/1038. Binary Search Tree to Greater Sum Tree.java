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
    public TreeNode bstToGst(TreeNode root) {
        bstToGstSum(root, 0);
        return root;
    }

    public int bstToGstSum(TreeNode root, int sum) {
        if (root == null) return sum;
        if (root.right == null && root.left == null) {
            root.val += sum;
            return root.val;
        } else {
            root.val += bstToGstSum(root.right, sum);
            sum = bstToGstSum(root.left, root.val);
            return sum;
        }
    }
}