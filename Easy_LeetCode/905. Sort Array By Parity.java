class Solution {
    public int[] sortArrayByParity(int[] A) {
        int l = 0;
        int r = A.length - 1;
        while (l < r) {
            if (A[l] % 2 == 0) {
                l++;
            } else if (A[r] % 2 == 1) {
                r--;
            } else {
                swap(A, l++, r--);
            }
        }
        return A;
    }
    
    private void swap(int[] array, int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }
}