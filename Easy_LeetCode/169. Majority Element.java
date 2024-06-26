class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num: nums) {
            if (count == 0) {
                res = num;
            }
            count += (res == num) ? 1 : -1;
        }
        return res;
    }
}
//------------------------------------------------

public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
       int n = nums.length;
       return nums[n/2];
        
    }
}