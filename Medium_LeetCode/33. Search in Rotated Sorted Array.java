class Solution {
    public int search(int[] nums, int target) {
    // Write your solution here
    if (nums == null || nums.length == 0) {
      return -1;
    }
    return helper(nums, 0, nums.length - 1, target);
  }

  private int helper(int[] a, int l, int r, int t) {
    if (l > r) {
      return - 1;
    }
    int m = l + (r - l) / 2;
    if (a[m] == t) {
      return m;
    } 
    
    if (a[l] <= a[m]) {
      if (t >= a[l] && t <= a[m]) {
        return helper(a, l, m - 1, t);
      }
      return helper(a, m + 1, r, t);
    } 
    
    if (t >= a[m] && t <= a[r]) {
      return helper(a, m + 1, r, t);
    }
    return helper(a, l, m - 1, t);
  }
}