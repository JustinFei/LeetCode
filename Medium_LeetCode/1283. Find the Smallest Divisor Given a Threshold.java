
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = nums[nums.length - 1];
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long num = computeSum(nums, mid);
            if (num > threshold) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // at the end of loop, left > right,
        // computeSum(right) > threshold
        // computeSum(left) <= threshold
        // --> return left
        return left;
    }
    
    private long computeSum(int[] nums, int x) {
        int sum = 0;
        for (int num: nums) {
            sum += (num / x + (num % x == 0 ? 0 : 1));
        }
        return sum;
    }
}
// Time Limit Exceeded
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int d = 1;
        while (computeSum(nums, d) > threshold) {
            d++;
        }
        return d;
    }
    
    private int computeSum(int[] nums, int x) {
        int sum = 0;
        for (int num: nums) {
            sum += (num / x + (num % x == 0 ? 0 : 1));
        }
        return sum;
    }
}
