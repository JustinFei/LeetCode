class Solution {
    public String smallestSubsequence(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] last = new int[26];
        boolean[] have = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (have[c]) continue;
            have[c] = true;
            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()]) {
                have[stack.pop()] = false;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : stack) sb.append((char)('a' + i));
        return sb.toString();
    }
}