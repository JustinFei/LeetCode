/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(0);
        Node cur = dummy;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new Node(head.val));
            }
            cur.next = map.get(head);
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                map.put(head.random, new Node(head.random.val));
            }
            cur.next.random = map.get(head.random);
            }
            
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }
}