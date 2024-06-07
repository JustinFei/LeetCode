class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int last[] = new int[128], res = 0;

        for (int i = 0; i < garbage.length; i++) {
            res += garbage[i].length();
            for (int j = 0; j < garbage[i].length(); j++) {
                last[garbage[i].charAt(j)] = i;
            }
        }

        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }

        for (int c: "MPG".toCharArray()) {
            if (last[c] > 0) {
                res += travel[last[c] - 1];
            }
        }

        return res;
    }
}