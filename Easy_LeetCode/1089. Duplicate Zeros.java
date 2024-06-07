class Solution {
    public void duplicateZeros(int[] arr) {
        // just count the zero we need to 
        int i = 0, countZero = 0;
        for (i = 0; countZero + i < arr.length; i++) {
            countZero += arr[i] == 0 ? 1 : 0;
        }
        for (i = i - 1; countZero > 0; i--) {
            if (i + countZero < arr.length) {
                arr[i + countZero] = arr[i];
            }
            if (arr[i] == 0) {
                arr[i + --countZero] = arr[i];
            }
        }
    }
}