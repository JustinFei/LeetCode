class Solution {
    public int largestCombination(int[] candidates) {
        int count, max = 0;
        for (int i = 0; i < 32; i++) {
            count = 0;
            for (int candidate : candidates) {
                count += candidate >> i & 1;
            }
            max = Math.max(count, max);
        }

        return max;
    }
}