class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> toOpen = new HashSet<>();
        for (int i = 1; i < n; i++) {
            toOpen.add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int curKey = q.poll();
            toOpen.remove(curKey);
            for (int k : rooms.get(curKey)) {
                if (toOpen.contains(k)) {
                    q.offer(k);
                }
            }
        }
        return toOpen.size() == 0;
    }
