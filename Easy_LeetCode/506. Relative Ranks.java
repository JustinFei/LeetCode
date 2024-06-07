public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null) return null;
        if (nums.length == 0) return new String[0];
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[index[i]] = "Gold Medal";
            } else if (i == 1) {
                res[index[i]] = "Silver Medal";
            } else if (i == 2) {
                res[index[i]] = "Bronze Medal";
            } else {
                res[index[i]] = i + 1 + "";
            }
        }
        return res;
    }
}