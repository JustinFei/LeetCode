class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b -a);
        for (int pile: piles) {
            pq.offer(pile);
        }

        for (int i = 0; i < k; i++) {
            int cur = pq.poll();
            int remove = cur / 2;
            pq.offer(cur - remove);
        }

        int res = 0;
        for (int num: pq) {
            res += num;
        }

        return res;
    }
}