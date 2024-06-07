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
class BSTIterator {
    private Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        if (root == null) return;
        stack = new LinkedList<TreeNode>();
        _add(root);
    }
    
    private void _add(TreeNode node) {
        if (node == null) return;
        stack.push(node);
        _add(node.left);
    }
    
    public int next() {
        TreeNode cur = stack.pop();
        if (cur.right != null) {
            _add(cur.right);
        }
        return cur.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

// ---------------------------------------
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
class BSTIterator {
    List<Integer> list;
    int p;
    
    public BSTIterator(TreeNode root) {
        list = new ArrayList<Integer>();
        p = 0;
        _inOrder(root);
    }
    
    private void _inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        _inOrder(root.left);
        list.add(root.val);
        _inOrder(root.right);
    }
    
    public int next() {
        return list.get(p++);
    }
    
    public boolean hasNext() {
        return p < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */