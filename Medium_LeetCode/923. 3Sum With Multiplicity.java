class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1_000_000_007;
        long res = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            int t = target - arr[i];
            while (j < k) {
                // These steps proceed as in a typical two-sum.
                if (arr[j] + arr[k] < t) {
                    j++;
                } else if (arr[j] + arr[k] > t) {
                    k--;
                } else if (arr[j] != arr[k]) {
                    // We have A[j] + A[k] == T.
                    // Let's count "left": the number of A[j] == A[j+1] == A[j+2] == ...
                    // And similarly for "right".
                    int left = 1, right = 1;
                    while (j + 1 < k && arr[j] == arr[j + 1]) {
                        j++;
                        left++;
                    }
                    
                    while (k - 1 > j && arr[k] == arr[k - 1]) {
                        k--;
                        right++;
                    }
                    
                    res += left * right;
                    res %= mod;
                    j++;
                    k--;
                } else {
                     // M = k - j + 1
                    // We contributed M * (M-1) / 2 pairs.
                    res += (k - j + 1) * (k - j) / 2;
                    res %= mod;
                    break;
                }
            }
        }
        return (int) res;
    }
}

//------------------------------------------------
/* 
    Count the occurrence of each number.
    using hashmap or array up to you.

    Loop i on all numbers,
    loop j on all numbers,
    check if k = target - i - j is valid.

    Add the number of this combination to result.
    3 cases covers all possible combination:

    i == j == k
    i == j != k
    i < k && j < k
    Time Complexity:
    3 <= A.length <= 3000, so N = 3000
    But 0 <= A[i] <= 100
    So my solution is O(N + 101 * 101)
*/
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long[] c = new long[101];
        for (int a : arr) c[a]++;
        long res = 0;
        for (int i = 0; i <= 100; i++)
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                else if (i == j && j != k)
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                else if (j < k)
                    res += c[i] * c[j] * c[k];
            }
        return (int) (res % (1e9 + 7));
    }
}