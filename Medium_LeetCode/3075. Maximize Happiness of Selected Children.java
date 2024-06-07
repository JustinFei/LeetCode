class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        int[] copy = Arrays.copyOf(happiness, happiness.length);
        // int[] copy = Arrays.stream(happiness).boxed()
        //         .sorted(Collections.reverseOrder())
        //         .mapToInt(Integer::intValue)
        //         .toArray();
        Arrays.sort(copy);

        long res = 0;
        int turns = 0;
        for (int i = n - 1; i >= n - k; i--) {
            res += Math.max(copy[i] - turns, 0);
            turns++;
        }

        return res;
    }
}