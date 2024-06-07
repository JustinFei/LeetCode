class Solution {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) return 0;
        int res = 1;
        Arrays.sort(stockPrices, (a, b) -> Integer.compare(a[0], b[0]));
        // Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        // Sort by occurence of each day and then check the slope
        // Time: O(NLogN), Space: O(1) / O(N) which depends on the type of sort used
        for (int i = 2; i < stockPrices.length; i++) {
            // Check if the slopes of three consecutive points are equal then continue
            // otherwise add another line to the count.
            // check (y2 - y1) / (x2 - x1) == (y1 - y0) / (x1 - x0) => (y2 - y1) * (x1 - x0) == (y1 - y0) * (x2 - x1)
            if ((stockPrices[i][1] - stockPrices[i - 1][1]) * (stockPrices[i - 1][0] - stockPrices[i - 2][0]) == 
                (stockPrices[i - 1][1] - stockPrices[i - 2][1]) * (stockPrices[i][0] - stockPrices[i - 1][0])) continue;
            res++;
        }

        return res;
    }
}