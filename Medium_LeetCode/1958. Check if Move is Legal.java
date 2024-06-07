class Solution {
    public boolean checkMove(char[][] b, int r, int c, char color) {
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1 , 1}, {-1, -1}};
        
        char op = color == 'W' ? 'B' : 'W'; //opposite color 
        
        for(int i = 0; i < 8; i++){
            int x = r;
            int y = c;
            int count = 1;
            x += dirs[i][0];
            y += dirs[i][1];
            
            while (x < 8 && y < 8 && x >= 0 && y >= 0 && b[x][y] != '.') {
                if(count != 1 && b[x][y] == color) return true;
                
                if(b[x][y]!= op) break;
                
                x += dirs[i][0];
                y += dirs[i][1];
                count++;
            }
        }
        return false;
    }
}