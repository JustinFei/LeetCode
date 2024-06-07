/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        List<Integer> cur = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() != 0) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                cur.add(node.val);
                for (Node n: node.children) {
                    queue.offer(n);
                }
                size--;
            }
            res.add(new ArrayList<Integer>(cur));
            cur.clear();
        }
        return res;
    }
}