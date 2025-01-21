class Solution {

    public long gridGame(int[][] grid) {
        // Calculate the sum of all the elements for the first row
        long firstRowSum = 0;
        for (int num : grid[0]) {
            firstRowSum += num;
        }
        long secondRowSum = 0;
        long minimumSum = Long.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            firstRowSum -= grid[0][i];
            // Find the minimum maximum value out of firstRowSum and
            // secondRowSum.
            minimumSum = Math.min(
                minimumSum,
                Math.max(firstRowSum, secondRowSum)
            );
            secondRowSum += grid[1][i];
        }
        return minimumSum;
    }
}