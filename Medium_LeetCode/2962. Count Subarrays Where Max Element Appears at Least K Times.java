class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        long res = 0;
        int start = 0, count = 0;

        for (int end = 0; end < nums.length; end++) {
            count += nums[end] == max ? 1 : 0;
            while (count == k) 
                count -= nums[start++] == max ? 1 : 0;
            res += start;
        }

        return res;
    }
}