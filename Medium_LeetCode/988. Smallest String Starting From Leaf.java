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
    String ans = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }
    
    private void dfs(TreeNode root, StringBuilder str) {
        str.append((char)(root.val + 'a'));
        
        if (root.left != null){
            dfs(root.left, str);
        }
        if (root.right != null){
            dfs(root.right, str);
        }
        
        if (root.left == null && root.right == null) {
            String tmp = str.reverse().toString();
            if (ans == "" || tmp.compareTo(ans) < 0){
                ans = tmp;
            }
            str.reverse();
        }
        str.deleteCharAt(str.length() - 1);
    }
}

// --------------------------------------

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
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode node, String suffix) {
        if (node == null) return suffix;
        suffix = "" + (char)('a' + node.val) + suffix;
        if (node.left == null && node.right == null) 
            return suffix;
        if (node.left == null || node.right == null) 
            return node.left == null ? dfs(node.right, suffix) : dfs(node.left, suffix);

        String left = dfs(node.left, suffix);
        String right = dfs(node.right, suffix);
    
        return left.compareTo(right) <= 0 ? left: right;
    }
}