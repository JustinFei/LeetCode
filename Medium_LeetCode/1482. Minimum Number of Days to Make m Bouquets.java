class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(((long) k * m) > bloomDay.length) return -1;
        int l = 1, r = 1000_000_000;
        while(l <= r) {
            int mid = l + ((r - l) / 2);
            if(helper(bloomDay, mid, m, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    boolean helper(int[] bloomDay, int day, int m, int k) {
        int i = 0;
        while(i < bloomDay.length && m > 0) {
            int c = 0;
            while(i < bloomDay.length) {
                if(bloomDay[i] <= day) {
                    c++;
                    if(c == k) {
                        m--;
                        break;
                    }
                } else {
                    break;
                }
                i++;
            }
            i++;
        }
        return m <= 0;
    }
}