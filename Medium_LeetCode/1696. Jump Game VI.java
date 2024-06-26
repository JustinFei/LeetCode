class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>(); // store index of `nums` elements, elements is in decreasing order, the front is the maximum element.
        int[] helper = new int[n];
        helper[0] = nums[0];
        dq.offer(0);
        for (int i = 1; i < n; ++i) {
            // nums[i] = max(nums[i-k], nums[i-k+1], .., nums[i-1]) + nums[i] = nums[dq.front()] + nums[i]
            helper[i] = helper[dq.peekFirst()] + nums[i];

            // Add nums[i] to our deque
            while (!dq.isEmpty() && helper[dq.peekLast()] <= helper[i]) dq.pollLast(); // Eliminate elements less or equal to nums[i], which will never be chosen in the future
            dq.offerLast(i);

            // Remove if the last element is out of window size k
            if (i - dq.peekFirst() >= k) dq.pollFirst();
        }
        return helper[n - 1];
    }
}