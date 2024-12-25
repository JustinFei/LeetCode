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

 // -------------- BFS -----------------
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur;
        int max, size;
        while (!q.isEmpty()) {
            max = Integer.MIN_VALUE;
            size = q.size();
            while (size -- > 0) {
                cur = q.poll();
                max = Math.max(cur.val, max);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}

// -------------- DFS -----------------


class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;

        if (level == res.size()) {
            res.add(root.val);
        } else {
            res.set(level, Math.max(res.get(level), root.val));
        }

        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }
}