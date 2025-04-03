
// -------- Approach 1: Brute-force enumeration ------ O(n ^ 3) --------
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length, ij;
        // if (n <= 2) return 0;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                ij = nums[i] - nums[j];
                for (int k = j + 1; k < n; k++) {
                    max = Math.max((long) ij * nums[k], max);
                }
            }
        }

        return max < 0 ? 0 : max;
    }
}

// ---------- Approach 2: Greedy ------------- O(n ^ 2) --------

class Solution {

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int k = 2; k < n; k++) {
            int maxPrefix = nums[0];
            for (int j = 1; j < k; j++) {
                res = Math.max(res, (long) (maxPrefix - nums[j]) * nums[k]);
                maxPrefix = Math.max(maxPrefix, nums[j]);
            }
        }
        return res;
    }
}

// --------- Approach 3: Greedy + Prefix Suffix Array ------- O(n) --------

public class Solution {

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[n - i]);
        }
        long res = 0;
        for (int j = 1; j < n - 1; j++) {
            res = Math.max(res, (long) (leftMax[j] - nums[j]) * rightMax[j]);
        }
        return res;
    }
}