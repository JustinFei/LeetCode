class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        combinationSum3(1, n, k, cur, res);
        return res;
    }
    
    private void combinationSum3(int start, int target, int k, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k && target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            combinationSum3(i + 1, target - i, k, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}