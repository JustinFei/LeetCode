class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] lis = new int[n + 1];
        Arrays.fill(lis, Integer.MAX_VALUE);
        lis[0] = Integer.MIN_VALUE;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            int cur = obstacles[i];

            int left = 0;
            int right = n;
            
            // find the count of numbers <= than cur
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (lis[mid] <= cur) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            lis[left] = cur;
            res[i] = left;
        }
        return res;
    }
}