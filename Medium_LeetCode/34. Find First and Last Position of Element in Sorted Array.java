class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}
//---------------------------------------------------

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        res[0] = first(nums, target);
        res[1] = second(nums, target);
        return res;
    }
    
    private int first(int[] n, int t) {
        int l = 0;
        int r = n.length - 1;
        int m;
        while (l < r - 1) {
            m = l + (r - l) / 2;
            if (n[m] >= t) {
                r = m;
            } else {
                l = m;
            }
        }
        if (n[l] == t) {
            return l;
        } else if (n[r] == t) {
            return r;
        }
        return -1;
    }
    
    private int second(int[] n, int t) {
        int l = 0;
        int r = n.length - 1;
        int m;
        while (l < r - 1) {
            m = l + (r - l) / 2;
            if (n[m] <= t) {
                l = m;
            } else {
                r = m;
            }
        }
        if (n[r] == t) {
            return r;
        } else if (n[l] == t) {
            return l;
        }
        return -1;
    }
}