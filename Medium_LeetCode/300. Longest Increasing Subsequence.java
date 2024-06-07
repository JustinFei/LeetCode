class Solution {
    // O(n ^ 2)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            max = Math.max(arr[i], max);
        }
        return max;
    }
}

//----------------------------------------------
class Solution {
    // O(n log n)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] arr = new int[nums.length + 1];
        int res = 1;
        arr[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int index = find(arr, 1, res, nums[i]);
            if (index == res) {
                arr[++res] = nums[i];
            } else {
                arr[index + 1] = nums[i];
            }
        }
        return res;
    }
    
    private int find(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

//----------------------------------------------------

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > list.get(list.size() - 1)) list.add(num); 
            else list.set(binarySearch(num, list), num);
        }
        return list.size();
    }
    
    private int binarySearch(int num, List<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (list.get(mid) == num)  {
                return mid;
            } else if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}