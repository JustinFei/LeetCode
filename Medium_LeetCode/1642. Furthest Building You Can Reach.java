class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int d;
        for (int i = 0; i < heights.length - 1; i++) {
            d = heights[i + 1] - heights[i];
            if (d > 0) {
                pq.add(d);
            } 
            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }
            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }
}

// ---------------------------------------------------------------------

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int sum = 0, n = heights.length;
        for (int i = 0; i < n - 1; i++)
            if (heights[i + 1] > heights[i])
                sum += heights[i + 1] - heights[i];
        if (sum <= bricks) return n - 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
        int max = 0, needed, preH;
        for (int i = 0; i < n; i++) {
            max = i;
            if (i < n - 1 && heights[i + 1] > heights[i]) {
                needed = heights[i + 1] - heights[i];
                if (bricks < needed) {
                    if (ladders > 0) {
                        if (!pq.isEmpty()) {
                            preH = pq.peek();
                            if (preH > needed) {
                                pq.poll();
                                bricks += preH - needed;
                                pq.offer(needed);
                            }
                        }
                        ladders--;
                    } else break;
                } else {
                    bricks -= needed;
                    pq.offer(needed);
                }
            }
        }

        return max;
    }
}