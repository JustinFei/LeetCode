class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int c = 0, n = map.size();
        int[] count = new int[n];

        for (int v : map.values()) {
            count[c++] = v;
        }

        Arrays.sort(count);
        for (int i = 0; i < n; i++) {
            k -= count[i];
            if (k == 0) {
                return n - i - 1;
            } else if (k < 0) {
                return n - i;
            }
        }

        return 0;
    }
}