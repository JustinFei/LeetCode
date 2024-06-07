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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> d1 = new LinkedList<>();
        Deque<TreeNode> d2 = new LinkedList<>();
        add(root1, d1);
        add(root2, d2);
        while (!d1.isEmpty() || !d2.isEmpty()) {
            root1 = d1.peekFirst();
            root2 = d2.peekFirst();
            if (root1 == null) {
                addRes(root2, d2, res);
            } else if (root2 == null) {
                addRes(root1, d1, res);
            } else {
                if (root1.val < root2.val) {
                    addRes(root1, d1, res);
                } else {
                    addRes(root2, d2, res);
                }
            }
        }
        return res;
    }
    
    private void add(TreeNode root, Deque<TreeNode> d) {
        while (root != null) {
            d.offerFirst(root);
            root = root.left;
        }
    }
    
    private void addRes(TreeNode root, Deque<TreeNode> d, List<Integer> res) {
        d.pollFirst();
        res.add(root.val);
        add(root.right, d);
    }
}