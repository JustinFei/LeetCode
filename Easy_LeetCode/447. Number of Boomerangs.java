public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) return 0;
        int n = points.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dis = getDis(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            
            for (int val: map.values()) {
                res += val * (val - 1);
            }
            map.clear();
        }
        
       
        return res;
    }
    
    private int getDis(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}