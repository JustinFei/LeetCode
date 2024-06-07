class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, m, r = letters.length - 1;
        if (letters[r] <= target || letters[l] > target) return letters[0];
        while (l < r - 1) {
            m = l + (r - l) / 2;
            if (letters[m] <= target) l = m;
            else r = m;
        }
        return letters[r];
    }
}