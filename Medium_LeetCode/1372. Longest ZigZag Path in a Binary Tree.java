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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestZigZag(root, true, 0);
        longestZigZag(root, false, 0);
        return max;
    }

    private void longestZigZag(TreeNode node, boolean fromLeft, int steps) {
        if (node == null) {
            return;
        }
        max = Math.max(max, steps);
        if (fromLeft) {
            longestZigZag(node.left, true, 1);
            longestZigZag(node.right, false, steps + 1);
        } else {
            longestZigZag(node.left, true, steps + 1);
            longestZigZag(node.right, false, 1);
        }
    }
}