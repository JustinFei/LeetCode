class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, 0, list, target);
        return res;
    }
    
    private void combinationSum(int[] candidates, int index, List<Integer> list, int target) {
        if (index == candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, i, list, target - candidates[i]);
            list.remove(list.size() - 1);
        }
        
    }
}

//-------------------------------------
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        } 
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        helper(candidates, target, 0, cur, result);
        return result;
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> cur, List<List<Integer>> result) {
        if (index == candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            helper(candidates, target - candidates[i], i, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}