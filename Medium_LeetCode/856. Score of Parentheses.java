class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> dq = new LinkedList<>();
        int cur = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                dq.offerLast(cur);
                cur = 0;
            } else {
                cur = dq.pollLast() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }
}

// -------------------------------------------
class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans
    }
}