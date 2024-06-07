class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int lmax = height[left];
        int rmax = height[right];
        int res = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                res += Math.max(0, lmax - height[left]);
                lmax = Math.max(lmax, height[left]);
                left++;
            } else {
                res += Math.max(0, rmax - height[right]);
                rmax = Math.max(rmax, height[right]);
                right--;
            }
        }
        return res;
    }
}