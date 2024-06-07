class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        for (int x = A.length, i; x > 0; x--) {
            for (i = 0; A[i] != x; i++);
            res.add(i + 1);
            reverse(A, i);
            res.add(x);
            reverse(A, x - 1);
            
        }
        return res;
    }
    
    private void reverse(int[] A, int j) {
        int i = 0;
        while (i < j) {
            int tmp = A[j];
            A[j] = A[i];
            A[i] = tmp;
            i++;
            j--;
        }
    }
}