class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        int result = 2;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    cnt.merge(Math.atan2(points[j][1] - points[i][1],
                        points[j][0] - points[i][0]), 1, Integer::sum);
                }
            }
            result = Math.max(result, Collections.max(cnt.values()) + 1);
        }
        return result;
    }
}

//--------------------------------------------------------------------

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        
        if (n == 1) {
            return 1;
        }
        
        int max = 0;    
        
        for (int i=0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j=i+1; j < n; j++) {
                double slope = calculateSlope(points[i], points[j]);
                
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            
                max = Math.max(max, map.get(slope));
            }    
        }

        return max + 1;
    }
    
    private double calculateSlope(int[] p1, int[] p2) {
        int x1 = p1[0], x2 = p2[0];
        int y1 = p1[1], y2 = p2[1];
        
        if (x1 == x2) return Double.MAX_VALUE;
        if (y1 == y2) return 0;
        return (double) (y2 - y1) / (double) (x2 - x1);
    }
}