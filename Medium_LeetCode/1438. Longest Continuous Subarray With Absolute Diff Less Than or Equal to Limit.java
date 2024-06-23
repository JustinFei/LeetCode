
// --------- Approach 1: Two Heaps ----------------
class Solution {

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        int left = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            maxHeap.offer(nums[right]);
            minHeap.offer(nums[right]);

            // Check if the absolute difference between the maximum and minimum values in the current window exceeds the limit
            while (maxHeap.peek() - minHeap.peek() > limit) {
                // Move the left pointer to the right until the condition is satisfied.
                // This ensures we remove the element causing the violation
                maxHeap.remove(nums[left]);
                minHeap.remove(nums[left]);
                left++;
            }

            // Update maxLength with the length of the current valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

// -------------- Approach 2: TreeMap ---------------------------------

class Solution {

    public int longestSubarray(int[] nums, int limit) {
        // TreeMap to maintain the elements within the current window
        TreeMap<Integer, Integer> window = new TreeMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);

            // Check if the absolute difference between the maximum and minimum values in the current window exceeds the limit
            while (window.lastKey() - window.firstKey() > limit) {
                // Remove the element at the left pointer from the TreeMap
                window.put(nums[left], window.get(nums[left]) - 1);
                if (window.get(nums[left]) == 0) {
                    window.remove(nums[left]);
                }
                // Move the left pointer to the right to exclude the element causing the violation
                left++;
            }

            // Update maxLength with the length of the current valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

// ---------------- Approach 3: Two Deques -------------------------------

class Solution {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; ++right) {
            // Maintain the maxDeque in decreasing order
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            // Maintain the minDeque in increasing order
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            // Check if the current window exceeds the limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                // Remove the elements that are out of the current window
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}