/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode first = null;
    TreeNode last = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        findSegments(root);
        int x = first.val;
        first.val = last.val;
        last.val = x;
    }

    public void findSegments(TreeNode root) {
        if(root == null) {
            return ;
        }
            
        findSegments(root.left);
        if (prev != null) {
            if (prev.val > root.val){
                if (first == null) {
                    first = prev;
                }
                last = root;
            }

        }

        prev = root;
        findSegments(root.right);
    }
}