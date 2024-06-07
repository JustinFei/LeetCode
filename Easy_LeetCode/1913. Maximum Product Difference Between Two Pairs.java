class Solution {
    public int maxProductDifference(int[] nums) {
        int a = 1, b = 1, c = 10000, d = 10000;
        // a > b, c < d
        for (int num : nums) {
            if (num > a) {
                b = a;
                a = num;
            } else if (num > b) {
                b = num;
            }

            if (num < d) {
                c = d;
                d = num;
            } else if (num < c) {
                c = num;
            }
        }

        return a * b - c * d;
    }
}

// -------------------------------

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length-1] * nums[nums.length-2] - nums[0]*nums[1];
    }
}