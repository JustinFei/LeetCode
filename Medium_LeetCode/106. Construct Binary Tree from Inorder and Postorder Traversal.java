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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

   HashMap<Integer, Integer> inMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(inorder, postorder, inMap, 0, inorder.length-1, 0, 
                          postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, HashMap<Integer, Integer> inMap, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postRight]);
        int inMid = inMap.get(root.val);
        root.left = helper(inorder, postorder, inMap, inLeft , inMid - 1, postLeft, postLeft + inMid - inLeft - 1);
        root.right=  helper(inorder, postorder, inMap, inMid + 1, inRight, postLeft + inMid - inLeft, postRight - 1);
        return root;
    }
}