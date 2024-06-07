class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int minimumRounds = 0;
        for (Integer count : map.values()) {
            if (count == 1) {
                return - 1;
            }
            
            if (count % 3 == 0) {
                // Group all the task in triplets.
                minimumRounds += count / 3;
            } else {
                // If count % 3 = 1; (count / 3 - 1) groups of triplets and 2 pairs.
                // If count % 3 = 2; (count / 3) groups of triplets and 1 pair.
                minimumRounds += count / 3 + 1;
            }
        }
        return minimumRounds;
    }
}