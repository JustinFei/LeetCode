class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] array = new int[nums.length + 1];
        for (int[] query : queries) {
            array[query[0]]++;
            array[query[1] + 1]--;
        }
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += array[i];
            if (cur < nums[i]) return false;
        }

        return true;
    }
}