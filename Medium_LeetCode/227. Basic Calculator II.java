class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        int num = 0;
        Deque<Integer> deq = new LinkedList<>();
        char sign = '+';
        for(char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c != ' ') {
                switch (sign) {
                    case '+':
                        deq.offerFirst(num);
                        break;
                    case '-':
                        deq.offerFirst(-num);
                        break;
                    case '*':
                        deq.offerFirst(deq.pollFirst() * num);
                        break;
                    case '/':
                        deq.offerFirst(deq.pollFirst() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        switch (sign) {
            case '+':
                deq.offerFirst(num);
                break;
            case '-':
                deq.offerFirst(-num);
                break;
            case '*':
                deq.offerFirst(deq.pollFirst() * num);
                break;
            case '/':
                deq.offerFirst(deq.pollFirst() / num);
                break;
        }
        int res = 0;
        while (!deq.isEmpty()) {
            res += deq.pollFirst();
        }
        return res;
    }
}