class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if(root == null){
            return res;
        }
        TreeNode[] temp = new TreeNode[2];
        
        if(root.val > V) {
            res[1] = root;
            if(root.left != null){
                temp = splitBST(root.left, V);
            }
            res[0] = temp[0];
            res[1].left = temp[1];
        }
        else {
            res[0] = root;
            if(root.right != null)
                temp = splitBST(root.right, V);
            res[1] = temp[1];
            res[0].right = temp[0];
        }
        return res;
    }
}

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
    public TreeNode[] splitBST(TreeNode root, int V) {
     TreeNode[] res = new TreeNode[2];
        if (root == null) return res;
        if (root.val == V) {
          res[1] = root.right;
          res[0] = root;
         res[0].right = null;
         return res;
        } else if (root.val > V) {
         TreeNode point = findNode(root, V);
         if (point == null) {
          res[1] = root;
          return res;
         }

         res[1] = root;

         TreeNode tmp = root;
         while (tmp.left != null && tmp.left.val > V) {
          tmp = tmp.left;
         }
         res[0] = tmp.left;
         tmp.left = point.right;
         point.right = null;
        } else {
         TreeNode point = findNode(root, V);
         if (point == null) {
          res[0] = root;
          return res;
         }

         res[0] = root;

         res[1] = point.right;
         point.right = null;
        }
        return res;
    }

    private TreeNode findNode(TreeNode root, int V) {
     if(root == null) return null;
     if (root.val > V){
      return findNode(root.left, V);
     } else if (root.val < V){
      if (root.right != null && root.right.val <= V) return findNode(root.right, V);
     }
     return root;
    }
}