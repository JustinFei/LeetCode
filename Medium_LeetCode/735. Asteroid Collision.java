class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length <= 1) {
            return asteroids;
        }
        
        // Stack
        Deque<Integer> deque = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                deque.offerFirst(asteroid);
            } else {
                while (!deque.isEmpty() && deque.peekFirst() > 0 && Math.abs(deque.peekFirst()) < Math.abs(asteroid)) {
                    deque.pollFirst();
                }
                if (deque.isEmpty() || deque.peekFirst() < 0) {
                    deque.offerFirst(asteroid);
                } else if (deque.peekFirst() == Math.abs(asteroid)) {
                    deque.pollFirst();
                }
            }
        }
        int[] res = new int[deque.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = deque.pollFirst();
        }
        return res;
    }
}