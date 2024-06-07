class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());
        for (int n: nums) {
            pq.offer(n);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cur = pq.peek();
        while (!pq.isEmpty()) {
            if (cur == pq.peek()) {
                pq.poll();
            } else {
                map.put(cur, pq.size());
                cur = pq.peek();
            }
        }
        map.put(cur, 0);
        int[] res = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}