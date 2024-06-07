class Solution { // O(n) O(n)
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int i = 0;
        for (int n: A) {
            if (n % 2 == 0) {
                res[i] = n;
                i += 2;
            }
        }
        
        i = 1;
        for (int n : A) {
            if (n % 2 == 1) {
                res[i] = n;
                i += 2;
            }
        }
        return res;
    }
}

//------------------
class Solution { // O(n) O(1)
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}