class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] seen = new boolean[8][8];
        for (int[] queen: queens) seen[queen[0]][queen[1]] = true;

        int[] dirs = {-1, 0 , 1};
        int x, y;
        for (int dx: dirs) {
            for (int dy: dirs) {
                if (dx == 0 && dy == 0) continue;
                x = king[0];
                y = king[1];
                while (x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8) {
                    x += dx;
                    y += dy;
                    if (seen[x][y]) {
                        res.add(Arrays.asList(x, y));
                        break;
                    }
                }
            }
        }
        return res;
    }
}