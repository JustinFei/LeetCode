class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        move();
        int res = q1.poll();
        swap();
        return res;
    }
    
    public int top() {
        move();
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }

    private void move() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
    }

    private void swap() {
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */