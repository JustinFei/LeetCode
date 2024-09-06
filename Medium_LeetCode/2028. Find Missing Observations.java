class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int curSum = Arrays.stream(rolls).sum(), m = rolls.length;
        int missingSum = mean * (m + n) - curSum;
        if (missingSum < n || missingSum > 6 * n) return new int[0];

        int base = missingSum / n, rem = missingSum % n;
        int[] res = new int[n];
        Arrays.fill(res, base);
        for (int i = 0; i < rem; i++) res[i]++;

        return res;
    }
}