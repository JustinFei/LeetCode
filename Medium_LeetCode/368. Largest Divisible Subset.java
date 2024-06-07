class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        
        int[] count = new int[nums.length];
        int[] prev = new int[nums.length];
        int max = 0;
        int index = -1;
        
        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && count[i] < count[j] + 1) {
                    count[i] = count[j] + 1;
                    prev[i] = j;
                }
            }
             if (max < count[i]) {
                max = count[i];
                index = i;
            }
        }
        
        while (index != -1) {
            res.add(nums[index]);
            index = prev[index];
        }
        return res;
    }
}