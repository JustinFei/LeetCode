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
public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        // Create a queue for nodes that need to be visited and add the root
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        queue.add(current);

        // Keeps track of whether we are on an even level
        boolean even = true;

        // While there are more nodes in the queue
        // Determine the size of the level and handle the nodes
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Prev holds the value of the previous node in this level
            int prev = Integer.MAX_VALUE;
            if (even) {
                prev = Integer.MIN_VALUE;
            }

            // While there are more nodes in this level
            // Remove a node, check whether it satisfies the conditions
            // Add its children to the queue
            while (size > 0) {
                current = queue.poll();

                // If on an even level, check that the node's value is odd and greater than prev
                // If on an odd level, check that the node's value is even and less than prev
                if ((even && (current.val % 2 == 0 || current.val <= prev)) ||
                        (!even && (current.val % 2 == 1 || current.val >= prev))) {
                    return false;
                }

                prev = current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                // Decrement size, we have handled a node on this level
                size--;
            }
            // Flip the value of even, the next level will be opposite
            even = !even;
        }
        // If every node meets the conditions, the tree is Even-Odd
        return true;
    }
}


// dfs -----------------------

public class Solution {
    private List<Integer> prev = new ArrayList<>();

    public boolean isEvenOddTree(TreeNode root) {
        TreeNode current = root;
        return dfs(current, 0);
    }

    private boolean dfs(TreeNode current, int level) {
        // Base case, an empty tree is Even-Odd
        if (current == null) {
            return true;
        }

        // Compare the parity of current and level
        if (current.val % 2 == level % 2) {
            return false;
        }

        // Add a new level to prev if we've reached a new level
        while (prev.size() <= level) {
            prev.add(0);
        }

        // If there are previous nodes on this level, check increasing/decreasing
        // If on an even level, check that current's value is greater than the previous on this level
        // If on an odd level, check that current's value is less than the previous on this level
        if (prev.get(level) != 0 && 
                ((level % 2 == 0 && current.val <= prev.get(level)) || 
                 (level % 2 == 1 && current.val >= prev.get(level)))) {
            return false;
        }

        // Add current value to prev at index level
        prev.set(level, current.val);

        // Recursively call DFS on the left and right children
        return dfs(current.left, level + 1) && dfs(current.right, level + 1);
    }
}
