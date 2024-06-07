class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        
        int[] arr = new int[n];
        arr[0] = pref[0];
        for (int i = 1; i < n; i++) {
            arr[i] = pref[i] ^ pref[i - 1];
        }
        
        return arr;
    }
}

/*

Since
pref[i] = pref[i-1] ^ A[i]
so we have
pref[i] ^ pref[i-1] = A[i]

*/

// -----------------------

class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        
        int[] arr = Arrays.copyOfRange(pref, 0, pref.length);

        for (int i = n - 1; i > 0; i--) {
            arr[i] ^= arr[i - 1];
        }
        
        return arr;
    }
}

