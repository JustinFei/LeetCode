class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int dup = 0, n = nums.length;
        long sum = (n * (n + 1)) / 2;
        for (int num : nums) {
            if (!set.add(num)) dup = num;
            sum -= num;
        }

        return new int[] {dup, (int) sum + dup};
    }
}

//----------------------

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length];
        int dup = 0, miss = 0;
        for (int n: nums) {
            if (nums[Math.abs(n) - 1] < 0) {
                dup = Math.abs(n);
            } else {
                nums[Math.abs(n) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                miss = i + 1;
            }
        }
        return new int[]{dup, miss};
    }
}