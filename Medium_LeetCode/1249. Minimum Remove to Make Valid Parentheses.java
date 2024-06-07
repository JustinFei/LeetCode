class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                    dq.offerFirst(i);
            } else if (s.charAt(i) == ')') {
                if (!dq.isEmpty() && s.charAt(dq.peekFirst()) == '(') {
                    dq.pollFirst();
                } else {
                    dq.offerFirst(i);
                }
            }
        }
        while (!dq.isEmpty()) {
            sb.deleteCharAt(dq.pollFirst());
        }
        return sb.toString();
    }
}