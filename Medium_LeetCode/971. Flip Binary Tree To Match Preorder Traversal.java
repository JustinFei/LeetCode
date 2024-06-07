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
    List<Integer> res = new ArrayList<>();
    int i = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? res : Arrays.asList(-1);
    }

    public Boolean dfs(TreeNode node, int[] voyage) {
        if (node == null) return true;
        if (node.val != voyage[i++]) return false;
        if (node.left != null && node.left.val != voyage[i]) {
            res.add(node.val);
            return dfs(node.right, voyage) && dfs(node.left, voyage);
        }
        return dfs(node.left, voyage) && dfs(node.right, voyage);
    }
}
//-------------------------------------------------------------------------------------
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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offerLast(root);
        int i = 0;
        TreeNode cur = null;
        while (!q.isEmpty() || cur != null) {
            if (cur == null) {
                cur = q.pollLast();
            }
            if (voyage[i++] != cur.val) {
                return Arrays.asList(new Integer[]{-1});
            } else {
                if (cur.left == null && cur.right == null) {
                    cur = null;
                } else if (cur.left == null || cur.right == null) {
                    cur = cur.left == null ? cur.right : cur.left;
                } else {
                    if (cur.left.val == voyage[i]) {
                        q.offerLast(cur.right);
                        cur = cur.left;
                    } else if (cur.right.val == voyage[i]) {
                        q.offerLast(cur.left);
                        res.add(cur.val);
                        cur = cur.right;
                    } else {
                        return Arrays.asList(new Integer[]{-1});
                    }
                }
            }
        }
        return res;
    }
}