class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;   
        }
        Deque<Integer> stack = new LinkedList<>();
        int cur = 0, res = 0;
        for (int i = 0; i <= heights.length; i++) {
            cur = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peekFirst()] >= cur) {
                int height = heights[stack.pollFirst()];
                int left = stack.isEmpty() ?  -1 : stack.peekFirst();
                res = Math.max(res, height * (i - left - 1));
            }
            stack.offerFirst(i);
        }
        return res;
    }
}