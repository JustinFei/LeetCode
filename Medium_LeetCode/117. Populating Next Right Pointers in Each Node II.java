/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node node = root, levelHead = new Node(0);
        while (node != null) {
            Node cur = levelHead;
            while (node != null) {
                if (node.left != null) {
                    cur.next = node.left;
                    cur = cur.next;
                }
                if (node.right != null) {
                    cur.next = node.right;
                    cur = cur.next;
                }
                node = node.next;
            }
            node = levelHead.next;
            levelHead.next = null;
        }
        return root;
    }
}
//-----------------------------------------------

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (i != size - 1) {
                    cur.next = q.peek();
                }
                
            }
        }
        return root;
    }
}