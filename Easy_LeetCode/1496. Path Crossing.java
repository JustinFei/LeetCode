class Solution {
    public boolean isPathCrossing(String path) {
        Map<Character, Pair<Integer, Integer>> moves = new HashMap<>();
        moves.put('N', new Pair(0, 1));
        moves.put('S', new Pair(0, -1));
        moves.put('W', new Pair(-1, 0));
        moves.put('E', new Pair(1, 0));

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair(0, 0));

        int x = 0, y = 0;
        Pair<Integer, Integer> move, cur;
        for (char c : path.toCharArray()) {
            move = moves.get(c);
            x += move.getKey();
            y += move.getValue();

            cur = new Pair(x, y);
            if (visited.contains(cur)) {
                return true;
            }

            visited.add(cur);
        }

        return false;
    }
}