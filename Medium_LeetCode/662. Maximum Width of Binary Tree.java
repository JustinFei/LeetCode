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
    private int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> startOfLevel = new LinkedList<>();
        dfs(root, 0, 1, startOfLevel);
        return max;
    }
    public void dfs(TreeNode root, int level, int index, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(index);
        }
        max = Math.max(max, index + 1 - list.get(level));
        dfs(root.left, level + 1, index * 2, list);
        dfs(root.right, level + 1, index * 2 + 1, list);
    }
}