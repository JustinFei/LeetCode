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
    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap();
        parent = new HashMap();
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}

//-------------------BFS-------
public boolean isCousins(TreeNode root, int A, int B) {
    if (root == null) return false;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        boolean isAexist = false;       
        boolean isBexist = false;       
        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();
            if (cur.val == A) isAexist = true;
            if (cur.val == B) isBexist = true;
            if (cur.left != null && cur.right != null) { 
                if (cur.left.val == A && cur.right.val == B) { 
                    return false;
                }
                if (cur.left.val == B && cur.right.val == A) { 
                    return false;
                }
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        if (isAexist && isBexist)  return true;
    }
    return false;
}