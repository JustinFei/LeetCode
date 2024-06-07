
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
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int count) {
        if (root == null) return 0;
        //  XOR Check if there is only one bit set
        count ^= 1 << (root.val - 1);
        int res = dfs(root.left, count) + dfs(root.right, count);
        // 8 & 7 == 0, 0 & -1 == 0
        if (root.left == root.right && (count & (count - 1)) == 0) res++;
        return res;
    }
}

//-------------------------------------------------------------

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
    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] array = new int[10];
        int[] res = new int[]{0};
        pseudoPalindromicPaths(root, array, res);
        return res[0];
    }
    
    private void pseudoPalindromicPaths(TreeNode root, int[] array, int[] res) {
        if (root == null) {
            return;
        }
        array[root.val]++;
        if (root.left == null && root.right == null) {
            if (isPseudoPalindromic(array)) {
                res[0]++;
            }
        }
        pseudoPalindromicPaths(root.left, array, res);
        pseudoPalindromicPaths(root.right, array, res);
        array[root.val]--;
    }
    
    private boolean isPseudoPalindromic(int[] array) {
        boolean single = false;
        for (int n : array) {
            if (n % 2 == 1) {
                if (!single) {
                    single = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}