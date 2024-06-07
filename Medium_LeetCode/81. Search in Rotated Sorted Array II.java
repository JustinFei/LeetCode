class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    
    public boolean search(int[] nums, int target, int start, int end) {
		//return false if start pointer bigger than end pointer or this part of array is sorted and target isn't there
        if(start > end || (nums[start] < nums[end] && (target < nums[start] || target > nums[end]))) {
            return false;
        }
		
        int middlePoint = (start + end) / 2;
        //return true if target is found
		if (nums[middlePoint] == target) {
            return true;
        }
		//devide this part of array on two parts and check each of them
        return search(nums, target, start, middlePoint - 1) || search(nums, target, middlePoint + 1, end);
    }
}