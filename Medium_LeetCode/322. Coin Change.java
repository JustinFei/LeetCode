class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int min = Integer.MAX_VALUE;
        for (int coin: coins) {
            int cur = 0;
            if (amount >= coin) {
                int next = coinChange(coins, amount - coin);
                if(next >= 0)
                    cur = 1 + next;
            }
            if (cur > 0) {
                min = Math.min(min, cur);
            }
        }
        int res = min == Integer.MAX_VALUE ? - 1: min;
        map.put(amount, res);
        return res;
    }
}