class Solution {
    public int findTheWinner(int n, int k) {
        // Initialize queue with n friends
        Queue<Integer> circle = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        // Perform eliminations while more than 1 player remains
        while (circle.size() > 1) {
            // Process the first k-1 friends without eliminating them
            for (int i = 0; i < k - 1; i++) {
                circle.add(circle.remove());
            }
            // Eliminate the k-th friend
            circle.remove();
        }

        return circle.peek();
    }
}

// -----------------------------------------------

class Solution {
    public int findTheWinner(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        // add 1 to convert back to 1 indexing
        return ans + 1;
    }
}