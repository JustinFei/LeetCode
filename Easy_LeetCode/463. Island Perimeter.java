class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}
//-----------------------------------

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length <=0 || grid[0].length <= 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    res += 4;
                    if (i > 0 && grid[i - 1][j] == 1) res -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) res -= 2;
                }
            }
        }
        return res;
    }
}

// ---------------------------------
class Solution {
    public int islandPerimeter(int[][] grid) {
       for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return getPerimeter(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int getPerimeter(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 1; // if boundary cross water everywhere 1
        if (grid[i][j] == 0) return 1; // if call is water 1
        if (grid[i][j] == -1) return 0; // if already visited 0

        grid[i][j] = -1; // update with -1 to mark visited no need of visited matrix
        int perimeter = 0;
        perimeter += getPerimeter(grid, i - 1, j);
        perimeter += getPerimeter(grid, i, j - 1);
        perimeter += getPerimeter(grid, i, j + 1);
        perimeter += getPerimeter(grid, i + 1, j);

        return perimeter;
    }
}