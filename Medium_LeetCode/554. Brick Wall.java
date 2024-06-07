class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, cur = 0, curMax = 0;
        for (List<Integer> row : wall) {
            sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                cur = map.getOrDefault(sum, 0);
                cur++;
                map.put(sum, cur);
                curMax = Math.max(cur, curMax);
            }
        }
        return wall.size() - curMax;
    }
}