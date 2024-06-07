
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
 if (inorder == null || preorder == null || inorder.length != preorder.length) {
            return null;
        }

   Map<Integer, Integer> inMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(inorder, preorder, inMap, 0, inorder.length - 1, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] preorder, Map<Integer, Integer> inMap, int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inMid = inMap.get(root.val);
        root.left = helper(inorder, preorder, inMap, inLeft , inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
        root.right=  helper(inorder, preorder, inMap, inMid + 1, inRight, preRight - inRight + inMid + 1, preRight);
        return root;
    }
}
//------------------------------------------------------
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
    int preIndex;
    int inIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inIndex = 0;
        return helper(inorder, preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] inOrder, int[] preOrder, int target) {
        if (inIndex >= inOrder.length || inOrder[inIndex] == target) {
          return null;
        }

        TreeNode root = new TreeNode(preOrder[preIndex]);
        preIndex++;
        root.left = helper(inOrder, preOrder, root.val);
        inIndex++;
        root.right = helper(inOrder, preOrder, target);
    return root;
  }
}