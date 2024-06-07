class Solution {
    public boolean reorderedPowerOf2(int N) {
        String S = Integer.toString(N);
        char[] arr = S.toCharArray();
        return permutations(arr, 0);
    }
    
    private boolean isPowerOfTwo(char[] arr) {
        if (arr[0] == '0') {
            return false;
        }
        int num = Integer.valueOf(new String(arr));
        return num > 0 && ((num & (num - 1)) == 0);
    }
    
    private boolean permutations(char[] arr, int idx) {
        if (idx == arr.length) {
            return isPowerOfTwo(arr);
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            if (permutations(arr, idx + 1)) {
                return true;
            }
            swap(arr, i, idx);
        }
        return false;
    }
    
    private void swap(char[] A, int i, int j) {
        char t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}

//----------------------------
class Solution {
     public boolean reorderedPowerOf2(int N) {
        long c = counter(N);
        for (int i = 0; i < 32; i++)
            if (counter(1 << i) == c) return true;
        return false;
    }
    public long counter(int N) {
        long res = 0;
        for (; N > 0; N /= 10) res += (int)Math.pow(10, N % 10);
        return res;
    }
}