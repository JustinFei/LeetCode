class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length, t = 0, cur = 0, max = 0;
        for (int i = 0; i < n; i++) t += grumpy[i] == 0 ? customers[i] : 0;
        for (int i = 0; i < minutes; i++) cur += grumpy[i] == 1 ? customers[i] : 0;
        max = cur;
        for (int i = minutes; i < n; i++) {
            cur += grumpy[i] == 1 ? customers[i] : 0;
            cur -= grumpy[i - minutes] == 1 ? customers[i - minutes] : 0;
            max = Math.max(max, cur);
        }
        return t + max;
    }
}