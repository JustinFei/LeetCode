class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int[] refund = new int[costs.length];
        int i = 0;
        int minCost = 0;
        for (int[] cost : costs)  {
            refund[i++] = cost[1] - cost[0];
            minCost += cost[0];
        }
        Arrays.sort(refund);
        for (int j = 0; j < costs.length / 2; j++) {
            minCost += refund[j];
        }
        return minCost;
    }
}