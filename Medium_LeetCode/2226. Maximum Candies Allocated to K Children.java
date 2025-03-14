class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }

        // right = 10_000_000
        int left = 0, right = max;
        while (left < right) {
            long sum = 0;
            int mid = left + (right - left + 1) / 2;
            for (int candy : candies) {
                sum += candy / mid;
            }
            if (k > sum)
                right = mid - 1;
            else
                left = mid;
        }
        return left;
    }
}