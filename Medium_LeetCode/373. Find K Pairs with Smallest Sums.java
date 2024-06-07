class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1])));
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 == 0 || len2 == 0) return Collections.emptyList(); 
        List<List<Integer>> res = new ArrayList<>();
        int min;
        if ((long)len1 * len2 > k) {
            min = k;
        }  else {
            min = len1 * len2;
        }
        for (int i = 0; i < Math.min(len1, k); i++) q.offer(new int[]{nums1[i], nums2[0], 0});
        for (int i = 0; i < min; i++) {
            int[] cur = q.poll();
            res.add(Arrays.asList(cur[0], cur[1]));
            if (cur[2] < len2 - 1) { 
                int idx = cur[2] + 1;
                q.offer(new int[]{cur[0], nums2[idx], idx});
            }
        }
        return res;
    }
}