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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        } 
        addOneRow(root, v, d - 1, 1);
        return root;
    }
    
    private void addOneRow(TreeNode node, int v, int d, int cur) {
        if (node == null) {
            return;
        }
        if (d == cur) {
            TreeNode newLeft = new TreeNode(v);
            newLeft.left = node.left; 
            node.left = newLeft;
            
            TreeNode newRight = new TreeNode(v);
            newRight.right = node.right; 
            node.right = newRight;
            return;
        }
        addOneRow(node.left, v, d, cur + 1);
        addOneRow(node.right, v, d, cur + 1);
    }
}