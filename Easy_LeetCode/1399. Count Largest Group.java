class Solution {

    public int countLargestGroup(int n) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            int key = 0, c = i;
            while (c != 0) {
                key += c % 10;
                c /= 10;
            }
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            maxValue = Math.max(maxValue, hashMap.get(key));
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> kvpair : hashMap.entrySet()) {
            if (kvpair.getValue() == maxValue) {
                count++;
            }
        }
        return count;
    }
}

// ---------------------------------------------

class Solution {

    public int countLargestGroup(int n) {
        int[] cnt = new int[37];
        int ans = 0, mx = 0;
        for (int i = 1; i <= n; i++) {
            int s = 0;
            for (int x = i; x > 0; x /= 10) {
                s += x % 10;
            }
            cnt[s]++;
            if (mx < cnt[s]) {
                mx = cnt[s];
                ans = 1;
            } else if (mx == cnt[s]) {
                ans++;
            }
        }
        return ans;
}