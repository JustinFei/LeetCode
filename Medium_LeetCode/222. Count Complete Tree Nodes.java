
// ------ O(log n * log n)

class Solution {
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                                         : (1 << h-1) + countNodes(root.left);
    }
}

public int countNodes(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int l = leftHeight(root.left);
    int r = leftHeight(root.right);
    if (l == r) { // left side is full
        return countNodes(root.right) + (1<<l);
    } 
    return countNodes(root.left) + (1<<r);
}

private int leftHeight(TreeNode node) {
    int h = 0;
    while (node != null) {
        h++;
        node = node.left;
    }
    return h;
}


// --------------- O(n)
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
}