
// --------- BFS ----------------------

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currLevelSum = root.val;
        while(!q.isEmpty()){
            int size = q.size();
            int nextLevelSum = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                curr.val = currLevelSum - curr.val;

                int left = curr.left == null ? 0: curr.left.val;
                int right = curr.right == null ? 0: curr.right.val;
                int siblingSum = left + right;
                
                if(curr.left != null){
                    nextLevelSum += left;
                    curr.left.val = siblingSum;
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    nextLevelSum += right;
                    curr.right.val = siblingSum;
                    q.offer(curr.right);
                }
            }
            currLevelSum = nextLevelSum;
        }
        return root;
    }
}

// ---------- DFS ------------------


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        dfs(root, 0, levelSum);
        dfs2(root, 0, levelSum);
        return root;
    }
    private void dfs(TreeNode node, int depth, List<Integer> levelSum) {
        if (node != null) {
            if (depth == levelSum.size()) {
                levelSum.add(0);
            }
            levelSum.set(depth, levelSum.get(depth) + node.val);
            dfs(node.left, depth + 1, levelSum);    
            dfs(node.right, depth + 1, levelSum);    
        }
    }
    private void dfs2(TreeNode node, int depth, List<Integer> levelSum) {
        if (node != null) {
            node.val = levelSum.get(depth) - node.val;
            if (node.left != null && node.right != null) {
                int siblingsSum = node.left.val + node.right.val;
                node.left.val = node.right.val = siblingsSum;
            }
            dfs2(node.left, depth + 1, levelSum);
            dfs2(node.right, depth + 1, levelSum);
        }
    }
}