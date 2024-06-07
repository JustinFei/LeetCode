/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        postOrder(root, res);
        return res;
    }
    
    private void postOrder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        for (Node node: root.children) {
            postOrder(node, res);
        }
        res.add(root.val);
    }
}