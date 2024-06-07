class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur  = new ArrayList<Integer>();
        helper(n, cur, res);
        return getList(n, res);
    }
    
    public void helper(int n, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == n) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(cur, i)) {
                cur.add(i);
                helper(n, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public boolean valid(List<Integer> cur, int column) {
        int row = cur.size();
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
                return false;
            }
        }
        return true;
    } 
    
    public List<List<String>> getList(int n, List<List<Integer>> numbersList) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> cur = new ArrayList<String>();
        for (int i = 0; i < numbersList.size(); i++) {
            cur.clear();
            List<Integer> numbers = numbersList.get(i);
            for (int j = 0; j < n; j++) {
                int p = numbers.get(j);
                String tmp = "";
                for (int k = 0; k < n; k++) {
                    if ( k == p) {
                        tmp += "Q";
                    } else {
                        tmp += ".";
                    }
                }
                cur.add(tmp);
            }
            res.add(new ArrayList<String>(cur));
        }
        return res;
    }
}