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
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = InOrder(root);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, list.get(i) - list.get(i -1));
        }
        return res;
    }
    
    private ArrayList<Integer> InOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}

//---------------------------------------------------------
class Solution {
    public int minDiffInBST(TreeNode root) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        getMin(root, min);
        return min[0];
    }
    
    private void getMin(TreeNode root, int[] min) {
        if (root == null) return;
        int tmp;
        if (root.left != null) {
            min[0] = Math.min(min[0], root.val - getRight(root.left).val);
            getMin(root.left, min);
        }
        if (root.right != null) {
            min[0] = Math.min(min[0], getLeft(root.right).val - root.val);
            getMin(root.right, min);
        }
    }
    
    private TreeNode getRight(TreeNode root) {
        while (root.right != null) root = root.right;
        return root;
    }
    
    private TreeNode getLeft(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }
}