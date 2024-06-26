class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2) {
            return false;
        } else if (coordinates.length == 2) {
            return true;
        }
        
        int x0 = coordinates[0][0], y0 = coordinates[0][1], 
            x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }
}