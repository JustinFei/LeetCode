class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < variables.length; i++)
            if(modpower(modpower(variables[i][0], variables[i][1], 10), variables[i][2], variables[i][3]) == target)
                res.add(i);
        
        return res;
    }
    
    public static int modpower(int x, int n, int m) {
        if (n == 0)
            return 1 % m; 
        long u = modpower(x, n / 2, m);  
        u = (u * u) % m;
        if (n % 2 == 1) 
            u = (u * x) % m;
        return (int) u;
    }
}