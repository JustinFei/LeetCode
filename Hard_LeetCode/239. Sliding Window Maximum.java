class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // List<Integer> max = new ArrayList<>();
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0 ; i < nums.length; i++) {
          while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast();
          }
          deque.offerLast(i);
          if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
            deque.pollFirst();
          }
          if (!deque.isEmpty() && i >= k - 1) {
            res[i - k + 1] = nums[deque.peekFirst()];
          }
        }
        
        return res;
    }
}