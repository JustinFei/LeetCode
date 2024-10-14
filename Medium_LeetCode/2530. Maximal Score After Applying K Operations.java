class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
        for (int num : nums) pq.offer(num);
        long res = 0;
        while (k > 0) {
            int cur = pq.poll();
            res += cur;
            pq.offer((int) Math.ceil((double) cur / 3));
            k--;
        }
        return res;
    }
}