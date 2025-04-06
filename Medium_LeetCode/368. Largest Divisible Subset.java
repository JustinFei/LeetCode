class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);
        Arrays.sort(arr);

        
        int[] dp = new int[n];
        int[] prev = new int[n];
        int max = 0;
        int index = -1;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] % arr[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
             if (max < dp[i]) {
                max = dp[i];
                index = i;
            }
        }
        
        while (index != -1) {
            res.add(arr[index]);
            index = prev[index];
        }
        return res;
    }
}