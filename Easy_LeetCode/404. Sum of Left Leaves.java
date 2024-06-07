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
    public int sumOfLeftLeaves(TreeNode root) {
       if (root == null || (root.left == null && root.right == null)) return 0;
       int sum = 0;
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       while (!queue.isEmpty()) {
           TreeNode cur = queue.poll();
           if (cur.left != null && cur.left.left == null && cur.left.right == null) sum += cur.left.val;
           if (cur.left != null) queue.offer(cur.left);
           if (cur.right != null) queue.offer(cur.right);
       }
        return sum;
    }
}