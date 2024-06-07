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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> cur = new ArrayList<>();
        preOrder(root, sum, cur, res);
        return res;
    }
    
    private void preOrder(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new ArrayList<Integer>(cur));
            }
        } 
        if (root.left != null) preOrder(root.left, sum - root.val, cur, res);
        if (root.right != null) preOrder(root.right, sum - root.val, cur, res);
        cur.remove(cur.size() - 1);   
    }
}