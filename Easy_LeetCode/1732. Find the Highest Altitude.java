class Solution {
    public int largestAltitude(int[] gain) {
        int cur = 0;
        int highest = 0;
        for (int g : gain) {
            cur += g;
            highest = Math.max(cur, highest);
        }
        return highest;
    }
}