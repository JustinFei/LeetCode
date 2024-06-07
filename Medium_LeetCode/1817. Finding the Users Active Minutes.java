class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.computeIfAbsent(log[0], v -> new HashSet<Integer>()).add(log[1]);
        }

        for (int key : map.keySet()) {
            res[map.get(key).size() - 1]++;
        }
        return res;
    }
}