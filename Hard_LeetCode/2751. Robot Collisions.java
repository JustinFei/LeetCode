class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));

        for (int cur : indices) {
            // Add right-moving robots to the stack
            if (directions.charAt(cur) == 'R') {
                stack.push(cur);
            } else {
                while (!stack.isEmpty() && healths[cur] > 0) {
                    // Pop the top robot from the stack for collision check
                    int topIndex = stack.pop();

                    // Top robot survives, current robot is destroyed
                    if (healths[topIndex] > healths[cur]) {
                        healths[topIndex] -= 1;
                        healths[cur] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[cur]) {
                        // Current robot survives, top robot is destroyed
                        healths[cur] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        // Both robots are destroyed
                        healths[cur] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        // Collect surviving robots
        for (int index = 0; index < n; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }
        return result;
    }
}