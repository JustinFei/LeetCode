class Solution {
        List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, list, target);
        return res;
    }
    
    private void combinationSum2(int[] candidates, int index, List<Integer> list, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            combinationSum2(candidates, i + 1, list, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}