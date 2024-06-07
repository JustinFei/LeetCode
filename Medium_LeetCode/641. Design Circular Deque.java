class MyCircularDeque {
    int size;
    int k;
    Node head;
    Node tail;
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        head.pre = tail;
        tail.next = head;

        this.k = k;
        this.size = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == k) 
            return false;
        size++;

        Node node = new Node(value);
        node.pre = head.pre;
        node.next = head;

        node.pre.next = node;
        head.pre = node;

        return true;

    }
    
    public boolean insertLast(int value) {
        if (size == k) 
            return false;
        size++;

        Node node = new Node(value);

        node.next = tail.next;
        node.pre = tail;

        tail.next  = node;
        node.next.pre = node;

        return true;
    }
    
    public boolean deleteFront() {
        if (size == 0) 
            return false;
        size--;

        head.pre.pre.next = head;
        head.pre = head.pre.pre;

        return true;
    }
    
    public boolean deleteLast() {
        if (size == 0) 
            return false;
        size--;

        tail.next.next.pre = tail;
        tail.next = tail.next.next;

        return true;
    }
    
    public int getFront() {
        return head.pre.val;
    }
    
    public int getRear() {
        return tail.next.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

class Node {
    Node pre;
    Node next;
    int val;
    public Node (int val) {
        this.val = val;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */


// ————————————————————————————————

class MyCircularDeque {
    private int head, tail, size, k;
    private final int[] a;
    public MyCircularDeque(int k) {
        a = new int[k];
        this.k = k;
        // head = 0;
        tail = 1;
    }
    
    public boolean insertFront(int value) {
        if (size == k) return false;
        a[head = ++head % k] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (size == k) return false;
        a[tail = (--tail + k) % k] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (size == 0) return false;
        head = (--head + k) % k;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (size == 0) return false;
        tail = ++tail % k;
        size--;
        return true;
    }
    
    public int getFront() {
        return size == 0 ? -1 : a[head];
    }
    
    public int getRear() {
        return size == 0 ? -1 : a[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */