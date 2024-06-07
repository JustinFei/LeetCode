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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
}
//-------iteratively 
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.pollFirst();
            if (cur.left != null) deque.offerFirst(cur.left);
            if (cur.right != null) deque.offerFirst(cur.right);
            res.add(cur.val);
        }
        Collections.reverse(res);
        return res;
    }
}

//-------iteratively 
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    stack.pollFirst();
                    res.add(cur.val);
                }
            } else if (prev == cur.left && cur.right == null || prev == cur.right) {
                stack.pollFirst();
                res.add(cur.val);
            } else {
                stack.offerFirst(cur.right);
            }
            prev = cur;
        }
        return res;
    }
}