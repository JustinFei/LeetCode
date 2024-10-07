class Solution {
    public int minLength(String s) {
        Deque<Character> dq = new LinkedList<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c =  s.charAt(i);
            if (c == 'B' && !dq.isEmpty() && dq.peekLast() == 'A'|| c == 'D' && !dq.isEmpty() && dq.peekLast() == 'C') {
                dq.pollLast();
            } else {
                dq.offerLast(c);
            }
        }

        return dq.size();
    }
}