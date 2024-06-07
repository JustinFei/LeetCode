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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        pathSum(root, targetSum, cur, res);
        return res;
    }
    
    private void pathSum(TreeNode node, int target, List<Integer> cur, List<List<Integer>> res) {
        cur.add(node.val);
        if (node.left == null && node.right == null && node.val == target) {
            
            res.add(new ArrayList<Integer>(cur));
            
        }
        if (node.left != null) {
            pathSum(node.left, target - node.val, cur, res);
        }
        if (node.right != null) {
            pathSum(node.right, target - node.val, cur, res);
        }
        cur.remove(cur.size() - 1);
    }
}