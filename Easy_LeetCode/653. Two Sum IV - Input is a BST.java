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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pollFirst();
                list.add(cur.val);
                cur = cur.right;
            } else {
                stack.offerFirst(cur);
                cur = cur.left;
            }
        }
        
        Integer[] array = new Integer[list.size()];
        array = list.toArray(array);
        int left = 0; 
        int right = array.length - 1;
        while (left < right) {
            int tmp = array[left] + array[right];
            if (tmp == k) return true;
            else if (tmp < k) left++;
            else right--;
        }
        return false;
    }
}