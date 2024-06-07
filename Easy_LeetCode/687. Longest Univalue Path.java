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
    int res;
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        help(root);
        return res;
    }
    public int help(TreeNode node) {
        if (node == null) return 0;
        int left = help(node.left);
        int right = help(node.right);
        int leftV = 0;
        int rightV = 0;
        if (node.left != null && node.left.val == node.val) {
            leftV = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rightV = right + 1;
        }
        res = Math.max(res, leftV + rightV);
        return Math.max(leftV, rightV);
    }
}