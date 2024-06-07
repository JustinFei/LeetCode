public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int num1 = nums[0];
        int num2 = nums[0];
        int cnt1 = 0; 
        int cnt2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (num1 == nums[i]) {
                cnt1++;
            } else if (num2 == nums[i]) {
                cnt2++;
            } else if (cnt1 == 0) {
                num1 = nums[i];
                cnt1++;
            } else if (cnt2 == 0) {
                num2 = nums[i];
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == num1) cnt1++;
            else if (num == num2) cnt2++;
        }
        
        if (cnt1 > n / 3) res.add(num1);
        if (cnt2 > n / 3) res.add(num2);
        return res;
    }
}