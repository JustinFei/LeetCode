class Solution {
    public int maximumCount(int[] nums) {
        int max = Integer.MIN_VALUE;
        int neg = 0, pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) neg++;
            else if (nums[i] > 0) pos++;
            max = Math.max(neg, pos);
        }

        return max;
    }
}

// -------------------------------------

class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int l = 0, m, r = n - 1;
        int neg = 0, pos = 0;
        while (l < r - 1) {
            m = l + (r - l) / 2;
            if (nums[m] >= 0) r = m;
            else l = m;
        }

        if (nums[r] < 0) neg = r + 1;
        else if (nums[l] < 0) neg = l + 1;
        
        l = 0;
        r = n - 1;
        while (l < r - 1) {
            m = l + (r - l) / 2;
            if (nums[m] <= 0) l = m;
            else r = m;
        }

        if (nums[l] > 0) pos = n - l;
        else if (nums[r] > 0) pos = n - r;

        return Math.max(neg, pos);
    }
}

// --------------------------

class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int neg = 0, zero = 0, pos = 0;
        int l = 0, m, r = n - 1;

        while (l <= r) {
            m = r + (l - r) / 2;
            if(nums[m] == 0){
                zero++;
                if(zero == n) return 0;
                if(m > 0 && nums[m - 1] < 0){
                    neg = m;
                    l = m + 1;
                } else if(m < n - 1 && nums[m + 1] > 0) {
                    pos = n - m - 1;
                    r = m - 1;
                } else if(nums[0] == 0 && nums[n - 1] != 0) {
                    l = m + 1;
                } else if(nums[0] != 0 && nums[n - 1] == 0) {
                    r = m - 1;
                }
                
            } else if(nums[m] < 0){
                neg = m + 1;
                l = m + 1;
            } else if(nums[m] > 0){
                pos = n - m;
                r = m - 1;
            }
        }

        return Math.max(neg, pos);
    }
}