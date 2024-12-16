class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int n = nums.length, cur[];
        for (int i = 0; i < n; i++) pq.offer(new int[]{nums[i], i});

        while (k-- > 0) {
            cur = pq.poll();
            pq.offer(new int[]{cur[0] * multiplier, cur[1]});
        }

        int[] res = new int[n];
        while (!pq.isEmpty()) {
            cur = pq.poll();
            res[cur[1]] = cur[0];
        }

        return res;
    }
}