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
    int i;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        i = 0;
        return helper(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] array, int bound) {
        if (i == array.length || array[i] > bound) {
            return null;
        }
        TreeNode node = new TreeNode(array[i++]);
        node.left = helper(array, node.val);
        node.right = helper(array, bound);
        return node;
    }
}