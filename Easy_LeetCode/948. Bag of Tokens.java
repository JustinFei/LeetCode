class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        if (tokens.length <= 0) {
            return 0;
        }
        int maxScore = 0;
        int score = 0;
        int l = 0, r = tokens.length - 1;
        while (l <= r) {
            if (P >= tokens[l]) {
                P -= tokens[l++];
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                P += tokens[r--];
                score--;
            } else break;
        }
        return maxScore;
    }
}