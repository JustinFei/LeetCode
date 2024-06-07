class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0, empty = 0, left = 0;
        while (numBottles > 0) {
            res += numBottles;
            empty = numBottles + left;
            numBottles = empty / numExchange;
            left = empty % numExchange;
        }
        return res;
    }
}