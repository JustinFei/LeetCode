class Solution {
    public String removeDuplicates(String s, int k) {
        int slow = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int fast = 0; fast < n; slow++, fast++) {
            stack[slow] = stack[fast];
            count[slow] = slow > 0 && stack[slow - 1] == stack[fast] ? count[slow - 1] + 1 : 1;
            if (count[slow] == k) {
                slow -= k;
            }
        }
        return new String(stack, 0, slow);
    }
}