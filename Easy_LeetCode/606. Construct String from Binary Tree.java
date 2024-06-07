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
class Solution { // O(n2)
    public String tree2str(TreeNode root) {
        String left = root.left != null ? "(" + tree2str(root.left) + ")" : "";
        String right = root.right != null ? "(" + tree2str(root.right) + ")" : "";

        if (root.left == null && root.right != null) right = "()" + right;
        return "" + root.val + left + right;
    }
}

// --------------------------------

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
class Solution { // O(n)
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) 
            return;
        sb.append(String.valueOf(node.val));

        if (node.left == null && node.right == null) 
            return;
        
        sb.append('(');
        dfs(node.left, sb);
        sb.append(')');

        if (node.right != null) {
            sb.append('(');
            dfs(node.right, sb);
            sb.append(')');
        }
    }
}