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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        List<Integer> list = new ArrayList<>();
        int[] cnt = { 0 };
        helper(root, list, sum, cnt);
        return cnt[0];
    }
    
    private void helper(TreeNode root, List<Integer> list, int sum, int[] cnt) {
        list.add(root.val);
        int tmp = 0;
        for(int i = list.size() - 1; i >=0; i--) {
            tmp += list.get(i);
            if (tmp == sum) cnt[0]++;
        }
        if (root.left != null) helper(root.left, list, sum, cnt);
        if (root.right != null) helper(root.right, list, sum, cnt);
        list.remove(list.size() - 1);
    }
}

//-----------------------------------------------------------------
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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, map, sum);
    }
    
    private int helper(TreeNode root, int prev, Map<Integer, Integer> map, int sum) {
        if (root == null) return 0;
        int cur = prev + root.val;
        int res = map.getOrDefault(cur - sum, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        res += helper(root.left, cur, map, sum) + helper(root.right, cur, map, sum);
        map.put(cur, map.get(cur) - 1);
        return res;
        
    }
}