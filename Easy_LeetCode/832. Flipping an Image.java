class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] a: A) {
            swap(a);
            for(int i = 0; i < a.length; i++) {
                a[i] ^= 1;
            }
        }
        return A;
    }
    
    private void swap(int[] a) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            l++;
            r--;
        }
    }
}