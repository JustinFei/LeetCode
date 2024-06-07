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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        int level = 0;
        while(!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (level == 0) {
                    TreeNode tmp = deque.pollFirst();
                    if (tmp.left != null) deque.offerLast(tmp.left);
                    if (tmp.right != null) deque.offerLast(tmp.right);
                    cur.add(tmp.val);  
                } else {
                    TreeNode tmp = deque.pollLast();
                    if (tmp.right != null) deque.offerFirst(tmp.right);
                    if (tmp.left != null) deque.offerFirst(tmp.left);
                    cur.add(tmp.val);
                }
            }
            res.add(cur);
            level = 1 - level;
        }
        return res;
    }
}