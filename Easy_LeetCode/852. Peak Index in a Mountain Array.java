class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }
        return index;
    }
}