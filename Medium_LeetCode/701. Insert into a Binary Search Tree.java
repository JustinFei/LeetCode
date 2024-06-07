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
    public TreeNode insertIntoBST(TreeNode root, int val) {
     // Write your solution here.
        if (root == null) {
          return new TreeNode(val);
        }
        insertHelper(root, val);
        return root;
      }

      private void insertHelper(TreeNode root, int val) {
        if (root.val == val) {
          return;
        }
        if (root.val > val && root.left == null) {
          root.left = new TreeNode(val);
        } else if (root.val > val) {
          insertHelper(root.left, val);
        } else if (root.val < val && root.right == null) {
          root.right = new TreeNode(val);
        } else {
          insertHelper(root.right, val);
        }
      }
}

//-----------------------------
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);;
        if (root == null) {
            return newNode;
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val <= val) {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = newNode;
                    break;
                }
            } else {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = newNode;
                    break;
                }
            }
        }
        return root;
    }
}