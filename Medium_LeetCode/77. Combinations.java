public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) return list;
        List<Integer> cur = new ArrayList<>();
        helper(0, 1, n, k, cur, list);
        return list;
    }
    
    private void helper(int index, int start, int n, int k, List<Integer> cur, List<List<Integer>> list) {
        if (index == k) {
            list.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; i <= (n - k + index + 1); i++) {
            cur.add(i);
            helper(index+1, i + 1, n, k, cur, list);
            cur.remove(cur.size() - 1);
        }
    }
}