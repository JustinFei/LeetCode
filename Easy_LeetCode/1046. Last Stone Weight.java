class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(11, Collections.reverseOrder());
        for (int stone : stones) {
            heap.offer(stone);
        }
        int tmp = 0;
        while(heap.size() > 1) {
            tmp = heap.poll() - heap.poll();
            if (tmp != 0) {
                heap.offer(tmp); 
            }
        }
        if (heap.size() == 1) {
            return heap.poll();
        }
        return 0;
    }
}