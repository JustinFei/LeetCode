class Solution {
    public boolean check(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        boolean flag = false;
        for (int i = 0; i < word1.length(); i++)
            if (word1.charAt(i) != word2.charAt(i)) {
                if (flag) return false;
                else flag = true;
            }
                
        return flag;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (
                    check(words[i], words[j]) &&
                    dp[j] + 1 > dp[i] &&
                    groups[i] != groups[j]
                ) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            ans.add(words[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}