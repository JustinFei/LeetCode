public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peekFirst() < num) {
                map.put(stack.pollFirst(), num);
            }
            stack.offerFirst(num);
        }
        int[] res = new int[findNums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.getOrDefault(findNums[i], - 1);
        }
        return res;
    }
}