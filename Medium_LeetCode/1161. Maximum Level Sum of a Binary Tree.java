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
    public int maxLevelSum(TreeNode root) {
        int curSum, max = Integer.MIN_VALUE;
        int qSize, curLevel = 0, level = 0;
        if (root == null) {
            return level;
        }
        TreeNode cur;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            curLevel++;
            curSum = 0;
            for (qSize = q.size(); qSize > 0; qSize--) {
                cur = q.poll();
                curSum += cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            if (curSum > max) {
                max = curSum;
                level = curLevel;
            }
        }
        return level;
    }
}