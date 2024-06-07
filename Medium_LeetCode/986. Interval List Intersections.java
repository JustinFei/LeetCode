class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        int m = A.length;
        int n = B.length;
        int i = 0; 
        int j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < m && j < n) {
            int startMax = Math.max(A[i][0], B[j][0]);
            int endMin = Math.min(A[i][1], B[j][1]);
            
            if (endMin >= startMax) {
                list.add(new int[]{startMax, endMin});
            }
            if (A[i][1] == endMin) {
                i++;
            }
            if (B[j][1] == endMin) {
                j++;
            }
        }
        
        int[][] res = new int[list.size()][2];
        i = 0;
        for(int[] pair: list){
            res[i++] = pair;
        }
        return res;
    }
}