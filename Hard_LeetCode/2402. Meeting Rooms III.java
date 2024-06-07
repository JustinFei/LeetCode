class Solution {
    public int mostBooked(int n, int[][] meetings) {
        var count = new int[n];
        var used = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        var unused = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            unused.offer(i);
        }

        for (int[] m : meetings) {
            int start = m[0], end = m[1];

            while (!used.isEmpty() && used.peek()[0] <= start) {
                int room = used.poll()[1];
                unused.offer(room);
            }

            if (unused.isEmpty()) {
                int nextAvailable = used.peek()[0];
                int room = used.poll()[1];
                used.offer(new int[]{nextAvailable - start + end, room});
                count[room]++;
            } else {
                int room = unused.poll();
                used.offer(new int[]{end, room});
                count[room]++;
            }
        }

        int res = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                res = i;
            }
        }

        return res;
    }
}