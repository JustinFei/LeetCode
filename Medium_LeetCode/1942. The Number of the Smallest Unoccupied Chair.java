// O(n^2) O(n)

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int[] targetTime = times[targetFriend];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        int n = times.length;
        int[] chairTime = new int[n];

        for (int[] time : times) {
            for (int i = 0; i < n; i++) {
                if (chairTime[i] <= time[0]) {
                    chairTime[i] = time[1];
                    if (Arrays.equals(time, targetTime)) return i;
                    break;
                }
            }
        }
        return 0;
    }
}

// -------------------------------

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int curMax = -1, lastSeat = -1, start = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> seats = new PriorityQueue<>();
      
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < times.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= times[i][0]) {
                seats.offer(pq.poll()[1]);
            }
            
            lastSeat = seats.isEmpty() ? ++curMax : seats.poll();            
            pq.offer(new int[]{times[i][1], lastSeat});
            if(times[i][0] == start) break;
        }
        
        return lastSeat;
    }
}