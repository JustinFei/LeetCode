class Solution {
    public int[] rearrangeArray(int[] nums) {
        for (int i  =1; i < nums.length - 1; ) {
            if (i > 0 && nums[i] * 2 == nums[i - 1] + nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                i--;
            } else i++;
        }
        return nums;
    }
}


// ------------------------------------------------

class Solution {
    public int[] rearrangeArray(int[] nums) {
        // int[] res = nums.clone();
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(res);
        for (int i = 1; i < res.length; i += 2) {
            int tmp = res[i];
            res[i] = res[i - 1];
            res[i - 1] = tmp;
        }

        return res;
    }
}
