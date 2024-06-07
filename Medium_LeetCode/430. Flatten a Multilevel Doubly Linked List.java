/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        
        Node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
            }
            
            Node tmp = p.child;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            if (p.next != null) {
                p.next.prev = tmp;
            }
            tmp.next = p.next;
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}