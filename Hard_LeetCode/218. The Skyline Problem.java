class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            // start point has negative height value
            heights.add(new int[]{b[0], -b[2]});
            // end point has normal height value
            heights.add(new int[]{b[1], b[2]});
        }
        
        // sort $height, based on the first value, if necessary, use the second to
        // break ties
        Collections.sort(heights, (a ,b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        // Use a maxHeap to store possible heights
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        
        // Provide a initial value to make it more consistent
        pq.offer(0);
        
        // Before starting, the previous max height is 0;
        int pre = 0, cur = 0;
        
        for (int[] h: heights) {
            if (h[1] < 0) { // a start point, add height
                pq.offer(-h[1]);
            } else {  // a end point, remove height
                pq.remove(h[1]);
            }
            
            cur = pq.peek(); // current max height;
            
            // compare current max height with previous max height, update result and 
            // previous max height if necessary
            if (pre != cur) {
                res.add(Arrays.asList(h[0], cur));
                pre = cur;
            }
        }
        return res;
    }
}