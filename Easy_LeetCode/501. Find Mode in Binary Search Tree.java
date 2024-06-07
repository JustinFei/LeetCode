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
public class Solution {
    private TreeNode prev;
    private int count = 0;
    private int maxCount = -1;
    
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList();
        prev = root;
        inorder(root, modes);

        // int[] res = new int[list.size()];
        // for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        // return res;
        return modes.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void inorder(TreeNode root, List<Integer> modes) {
        if (root == null) return;
        inorder(root.left, modes);
        count = prev.val == root.val ? count + 1 : 1;
        
        if (count == maxCount) {
            modes.add(root.val);
        } else if (count > maxCount) {
            modes.clear();
            modes.add(root.val);
            maxCount = count;
        }
        
        prev = root;
        inorder(root.right, modes);
    }
}