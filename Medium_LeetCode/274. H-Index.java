public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] > n) cnt[n]++;
            else cnt[citations[i]]++;
        }
        int total = 0;
        for (int i = n; i>= 0; i--) {
            total += cnt[i];
            if (total >= i) return i;
        }
        return 0;
    }
}