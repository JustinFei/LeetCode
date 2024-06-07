class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int max = -1;
        for (int num : nums)
            if (num < 0 && set.contains(-num) && -num > max) 
                max = -num;
        return max;
    }
}