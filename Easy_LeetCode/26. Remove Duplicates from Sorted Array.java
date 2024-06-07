public int removeDuplicates(int[] nums) {
    int cur = 0 ; 
    for(int n:nums)
        if(n>nums[cur])
            nums[++cur] = n;
    return cur+1;
}

//-------------------------------------
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int slow = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            nums[slow] = nums[i];
            slow++;
        }
        return slow;
    }
}