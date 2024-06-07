
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums.size() == 0) {
            return new int[0];
        }
        int maxKey = 0;
        int n = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int r = nums.size() - 1; r >= 0 ; r--) {
            for (int c = 0; c < nums.get(r).size(); c++) {
                map.putIfAbsent(r + c, new ArrayList<Integer>());
                map.get(r + c).add(nums.get(r).get(c));
                maxKey = Math.max(maxKey, r + c);
                n++;
            }
        }
        int[] res = new int[n];
        int i = 0;
        for (int key = 0; key <= maxKey; key++) {
            if (map.get(key) != null)
            for (int num: map.get(key)) {
                res[i++] = num;
            }
        }
        return res;
    }
}

// ----------------------


// My first solution. Time Limit Exceeded
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int totalNum = 0;
        int M = nums.size();
        int N = 0;
        for (List<Integer> num: nums) {
            totalNum += num.size();
            if (num.size() > N) {
                N = num.size();
            }
            
        }
        int[] res = new int[totalNum];
        findDiagonalOrder(nums, 0, 0, 0, M, N, res);
        return res;
    }
    
    private void findDiagonalOrder(List<List<Integer>> nums, int r, int c, int k, int M, int N, int[] res) {
        if (r < 0 || r >= M || c < 0 || c >= N) {
            return;
        }
        int i = r, j = c;
        while (i >= 0 && j < N) {
            if (j < nums.get(i).size()) {
                res[k++] = nums.get(i).get(j);
            }
            i--;
            j++;
        }
        if (r == M - 1) {
            findDiagonalOrder(nums, r, c + 1, k, M, N, res);
        } else {
            findDiagonalOrder(nums, r + 1, 0, k, M, N, res);
        }
    }
}