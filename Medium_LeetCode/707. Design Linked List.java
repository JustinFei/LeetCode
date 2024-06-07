class MyLinkedList {
    int size;
    Node head;
    Node tail;

    public MyLinkedList() {
        size = 0;
    }
    
    public int get(int index) {
        if (index >= size) return -1;
        Node cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        size++;
        Node newHead = new Node(val);
        if (size == 1) {
            head = newHead;
            tail = newHead;
            return;
        }

        head.prev = newHead;
        newHead.next = head;
        head = newHead;
    }
    
    public void addAtTail(int val) {
        size++;
        Node newTail = new Node(val);
        if (size == 1) {
            tail = newTail;
            head = newTail;
            return;
        }

        tail.next = newTail;
        newTail.prev = tail;
        tail = newTail;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        } else if (index == 0) {
            addAtHead(val);
            return;
        } else if (index == size) {
            addAtTail(val);
            return;
        }
        size++;

        Node cur = head;

        while (index > 1) {
            cur = cur.next;
            index--;
        }

        Node newNode = new Node(val, cur.next);
        cur.next.prev = newNode;
        newNode.prev = cur;
        cur.next = newNode;
        
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;
        else if (index == 0) {
            deleteAtHead();
            return;
        }
        else if (index == size - 1) {
            deleteAtTail();
            return;
        }

        size--;
        Node cur = head;
        while (index > 1) {
            cur = cur.next;
            index--;
        }

        cur.next = cur.next.next;
        cur.next.prev = cur;
    }

    private void deleteAtHead() {
        size--;

        if (size == 0) {
            head = null;
            tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    private void deleteAtTail() {
        size--;

        if (size == 0) {
            head = null;
            tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }
}

class Node {
    int val;
    Node prev;
    Node next;
    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    } 
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

 // --------------------------

 class MyLinkedList {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    private Node head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) return -1;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node prev = head;
        head = new Node(val);
        head.next = prev;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        size++;
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == 0) {
            addAtHead(val);
        } else {
            size++;
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node node = new Node(val);
            node.next = current.next;
            current.next = node;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) return;
        size--;
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */