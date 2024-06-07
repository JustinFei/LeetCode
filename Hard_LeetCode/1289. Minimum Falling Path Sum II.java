class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] mins = new int[m], cur = new int[m];

        // fm : first min, sm : second min
        // cfm : current first min, csm : second first min
        int res = Integer.MAX_VALUE,
            fm = Integer.MAX_VALUE,
            sm = Integer.MAX_VALUE , cfm, csm;

        for (int i = 0; i < m; i++) {
            mins[i] = grid[n - 1][i];
            res = Math.min(res, mins[i]);
            if (mins[i] < fm) {
                sm = fm;
                fm = mins[i];
            } else if (mins[i] < sm) {
                sm = mins[i];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            res = Integer.MAX_VALUE;
            cfm = Integer.MAX_VALUE; 
            csm = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                cur[j] = grid[i][j] + (mins[j] == fm ? sm : fm);
                res = Math.min(res, cur[j]);
                if (cur[j] < cfm) {
                    csm = cfm;
                    cfm = cur[j];
                } else if (cur[j] < csm) {
                    csm = cur[j];
                }
            }
            mins = cur;
            cur = new int[m];
            fm = cfm;
            sm = csm;
        }
        return res;
    }
}