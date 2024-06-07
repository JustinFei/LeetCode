// Sort the array. Ascend on width and descend on height if width are same.
// Find the longest increasing subsequence based on height.
// Since the width is increasing, we only need to consider height.
// [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]

class Solution {
    public int maxEnvelopes(int[][] E) {
        Arrays.sort(E, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[E.length];
        int ans = 0;
        for (int[] env : E) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, ans, height);
            if (left < 0) left = -left - 1;
            if (left == ans) ans++;
            dp[left] = height;
        }
        return ans;
    }
}

//------------------------------------------------------------

class Solution {
    // TC : O(n2)
    //SC: O(n), n no of envelopes
    public int maxEnvelopes(int[][] envelopes) {
        int maxEn = 1;

        Arrays.sort(envelopes, (a,b) -> (a[0] - b[0]));

        int len = envelopes.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for(int i = 0; i < len; i++) { //[0,len)
            for(int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] &&  envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxEn = Math.max(maxEn, dp[i]);
        }
        return maxEn;
    }
}