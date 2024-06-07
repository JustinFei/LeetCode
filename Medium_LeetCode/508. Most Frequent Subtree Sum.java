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
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        getMap(root, map);
        List<Integer> list = new ArrayList<>();
        int freq = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > freq) {
                list.clear();
                freq = entry.getValue();
                list.add(entry.getKey());
            } else if (entry.getValue() == freq) {
                list.add(entry.getKey());
            }
        }
        
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer num: list) {
            res[i++] = num;
        }
        return res;
    }
    
    private int getMap(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int left = getMap(root.left ,map);
        int right = getMap(root.right, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}