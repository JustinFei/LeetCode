class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        
        int n = A.length;
        if (A[0] < A[n - 1]) {
            for (int i = 0; i < n - 1; i++) {
                if (A[i] > A[ i + 1]) {
                    return false;
                }
            }
        } else if (A[0] > A[n - 1]) {
            for (int i = 0; i < n - 1; i++) {
                if (A[i] < A[ i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                if (A[i] != A[ i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

//-------------------------------------
class Solution {
    public boolean isMonotonic(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i+1]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }

        return true;
    }
}