class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] res = new int[1];
        dfs(nums, 0, 0, target, res);
        return res[0];
    }

    private void dfs(int[] nums, int i, int c, int t, int[] res) {
        if (i == nums.length) {
            if (c == t) res[0]++; 
            return;
        }
        dfs(nums, i + 1, c + nums[i], t, res);
        dfs(nums, i + 1, c - nums[i], t, res);
    }
}

// -------------------------------

public class Solution {

    // Sum of all elements in the array
    int totalSum;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();

        int[][] memo = new int[nums.length][2 * totalSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculateWays(nums, 0, 0, target, memo);
    }

    private int calculateWays(int[] nums, int i, int c, int t, int[][] memo) {
        if (i == nums.length) {
            // Check if the current sum matches the target
            if (c == t) return 1;
            else return 0;
        } 

        // Check if the result is already computed
        if (memo[i][c + totalSum] != Integer.MIN_VALUE) return memo[i][c + totalSum];
        
        // Calculate ways by adding the current number
        int add = calculateWays(nums, i + 1, c + nums[i], t, memo);

        // Calculate ways by subtracting the current number
        int subtract = calculateWays(nums, i + 1, c - nums[i], t, memo);

        // Store the result in memoization table
        memo[i][c + totalSum] = add + subtract;

        return memo[i][c + totalSum];
    }
}