class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        final List<String> res = new ArrayList<>();
        for (String word: words) {
            int length = word.length();
            boolean[] dp = new boolean[length + 1];
            dp[0] = true;
            for (int i = 1; i <= length; i++) {
                for (int j = (i == length ? 1 : 0); !dp[i] && j < i; j++) {
                    dp[i] = dp[j] && set.contains(word.substring(j, i));
                }
            }
            if (dp[length]) {
                res.add(word);
            }
        }
        return res;
    }
}