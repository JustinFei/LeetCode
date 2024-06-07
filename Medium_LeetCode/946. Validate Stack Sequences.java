class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        for (int num : pushed) {
            deque.offerLast(num);
            while (!deque.isEmpty() && deque.peekLast() == popped[i]) {
                deque.pollLast();
                i++;
            }
            
        }
        return deque.isEmpty();
    }
}