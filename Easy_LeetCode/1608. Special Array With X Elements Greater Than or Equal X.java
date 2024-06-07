
// O(nlogn) O(1)
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++)
            if (n - i <= nums[i] && ((i == 0) || (n - i > nums[i - 1])))
                return n - i;
        return -1;
    }
}

// O(n) O(n)

class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        for(int num : nums)
            if(num > n)
                count[n]++;
            else
                count[num]++;
        int bigNumsCount = 0;
        for(int i = n; i > 0; i--){
            bigNumsCount += count[i];
            if(bigNumsCount > i)
                return -1;
            if(bigNumsCount == i)
                return i;
        }
        return -1;
    }
}

