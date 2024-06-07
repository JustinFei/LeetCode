class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length, l = 0, r = n - 1;
        while (colors[0] == colors[r]) r--;
        while (colors[n - 1] == colors[l]) l++;
        return Math.max(n - 1 - l, r);
    }
}