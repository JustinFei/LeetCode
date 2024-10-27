
class Solution {
    public int countSquares(int[][] matrix) {
        int mat[][] = new int[matrix.length + 1][matrix[0].length + 1];
        int sum = 0;
        
        /*  We can do Dynamic Programming by saving how many
            Squares can be formed using the bottom right corner
            element.
        */
        
        for(int i = 1; i <= matrix.length; i++)
            for(int j = 1; j <= matrix[0].length; j++)
                if(matrix[i - 1][j - 1] != 0)
                    sum += (mat[i][j] = Math.min(Math.min(mat[i - 1][j], mat[i][j - 1]), mat[i - 1][j - 1]) + 1);
        
                
        /*
        Workin on the first example:
        ===========================
        Matrix =
        [0,1,1,1],
        [1,1,1,1],
        [0,1,1,1]
        ===========================
        mat after algorithm = 
        [0,0,0,0,0],
        [0,0,1,1,1],
        [0,1,1,2,2],
        [0,0,1,2,3]
        ===========================
        After summing all indicies, now we get the correct answer!
        */
                
        return sum;
    }
}

// -------------------

class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] counter = new int[m][n];
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        counter[i][j] = 1;
                        list.set(0, list.get(0) + 1);
                    } else {
                        counter[i][j] = Math.min(counter[i -1][j - 1], counter[i- 1][j]) + 1;
                        counter[i][j] = Math.min(counter[i][j - 1] + 1, counter[i][j]);
                        int l = counter[i][j];
                        if (l > list.size()) {
                            list.add(1);
                            l--;
                        }
                        for (int k = 0; k < l; k++) {
                            list.set(k, list.get(k) + 1);
                        }
                    }
                }
            }
        }
        
        for (Integer num: list) {
            res += num;
        }
        return res;
    }
}