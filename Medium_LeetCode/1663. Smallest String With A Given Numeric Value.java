class Solution {
// O(n) O(n)
    public String getSmallestString(int n, int k) {
        char[] ca = new char[n];
        Arrays.fill(ca, 'a');
        k -= n;
        for (int i = n - 1; i >= 0 && k > 0; i--) {
            ca[i] += Math.min(25, k);
            k -= Math.min(25, k);
        }
        return String.valueOf(ca);
    }
}

// ------------------------
class Solution {
// O(n) O(n)
    public String getSmallestString(int n, int k) {
        int z = (k - n) / 25, r = (k - n) % 25;
        return (z == n ? "" : "a".repeat(n - z - 1) + (char)('a' + r)) + "z".repeat(z);
    }
}