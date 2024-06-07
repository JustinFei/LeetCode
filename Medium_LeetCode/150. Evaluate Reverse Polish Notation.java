class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        int a, b;
        Deque<Integer> dq = new LinkedList<>();
        for (String s: tokens) {
            switch (s) {
                case "+":
                dq.offerLast(dq.pollLast() + dq.pollLast());
                break;
                case "-":
                    b = dq.pollLast();
                    a = dq.pollLast();
                    dq.offerLast(a - b);
                    break;
                case "*":
                    dq.offerLast(dq.pollLast() * dq.pollLast());
                    break;
                case "/":
                    b = dq.pollLast();
                    a = dq.pollLast();
                    dq.offerLast(a / b);
                    break;
                default:
                    dq.offerLast(Integer.parseInt(s));
            }
            
        }

        return dq.pollLast();
    }
}