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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int[] array = new int[2];
        inOrder(root, k, array);
        return array[1];
    }
    
    private void inOrder(TreeNode root, int k, int[] array) {
        if (root == null) return;
        inOrder(root.left, k, array);
        array[0]++;
        if (array[0] == k) array[1] = root.val;
        inOrder(root.right, k, array);
    }
}