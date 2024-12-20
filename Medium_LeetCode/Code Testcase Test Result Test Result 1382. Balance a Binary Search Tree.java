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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        inorderTraverse(root, arr);
        return sortedArrayToBST(0, arr.size() - 1, arr);
    }

    private void inorderTraverse(TreeNode node, List<TreeNode> arr) {
        if (node == null) return;
        inorderTraverse(node.left, arr);
        arr.add(node);
        inorderTraverse(node.right, arr);
    }

    private TreeNode sortedArrayToBST(int left, int right, List<TreeNode> arr) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = arr.get(mid);
        node.left = sortedArrayToBST(left, mid - 1, arr);
        node.right = sortedArrayToBST(mid + 1, right, arr);
        return node;
    }
}