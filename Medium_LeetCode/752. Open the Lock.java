class Solution {
    public int openLock(String[] deadends, String target) {
        // Map the next slot digit for each current slot digit.
        Map<Character, Character> nextSlot = Map.of(
            '0', '1', 
            '1', '2', 
            '2', '3', 
            '3', '4', 
            '4', '5', 
            '5', '6', 
            '6', '7', 
            '7', '8', 
            '8', '9', 
            '9', '0'
        );
        // Map the previous slot digit for each current slot digit.
        Map<Character, Character> prevSlot = Map.of(
            '0', '9', 
            '1', '0', 
            '2', '1', 
            '3', '2', 
            '4', '3', 
            '5', '4', 
            '6', '5', 
            '7', '6', 
            '8', '7', 
            '9', '8'
        );

        // Set to store visited and dead-end combinations.
        Set<String> v = new HashSet<>(Arrays.asList(deadends));
        // Queue to store combinations generated after each turn.
        Queue<String> q = new LinkedList<String>();

        // Count the number of wheel turns made.
        int turns = 0;

        // If the starting combination is also a dead-end, 
        // then we can't move from the starting combination.
        if (v.contains("0000")) {
            return -1;
        }

        // Start with the initial combination '0000'.
        q.add("0000");
        v.add("0000");

        while (!q.isEmpty()) {
            // Explore all the combinations of the current level.
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // Get the current combination from the front of the queue.
                String cur = q.poll();

                // If the current combination matches the target, 
                // return the number of turns/level.
                if (cur.equals(target)) {
                    return turns;
                }

                // Explore all possible new combinations by turning each wheel in both directions.
                for (int wheel = 0; wheel < 4; wheel++) {
                    // Generate the new combination by turning the wheel to the next digit.
                    StringBuilder next = new StringBuilder(cur);
                    next.setCharAt(wheel, nextSlot.get(next.charAt(wheel)));
                    // If the new combination is not a dead-end and was never visited, 
                    // add it to the queue and mark it as visited.
                    if (!v.contains(next.toString())) {
                        q.add(next.toString());
                        v.add(next.toString());
                    }

                    // Generate the new combination by turning the wheel to the previous digit.
                    next = new StringBuilder(cur);
                    next.setCharAt(wheel, prevSlot.get(next.charAt(wheel)));
                    // If the new combination is not a dead-end and is never visited, 
                    // add it to the queue and mark it as visited.
                    if (!v.contains(next.toString())) {
                        q.add(next.toString());
                        v.add(next.toString());
                    }
                }
            }
            // We will visit next-level combinations.
            turns += 1;
        }
        // We never reached the target combination.
        return -1;
    }
}