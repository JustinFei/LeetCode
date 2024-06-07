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
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        bfs(root, 1, max);
        return max[0];
    }
    public void bfs(Node node, int height, int[] max) {
        if (node.children.size() == 0) {
            max[0] = Math.max(max[0], height);
            return;
        }
        Iterator<Node> iterator = node.children.iterator();
        while (iterator.hasNext()) {
            bfs(iterator.next(), height + 1, max);
        }
    }
}