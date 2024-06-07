/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    List<String> result = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return result;
        getPath(root);
        return result;
    }
    
    public void getPath(TreeNode node){
        if(node == null) return;
        path.add(node.val);
        if(node.left == null && node.right == null){
            StringBuffer buffer = new StringBuffer();
            for(int i=0;i<path.size();i++){
                if(i!=0) buffer.append("->");
              buffer.append(path.get(i));
            }
            result.add(buffer.toString());
        }
        getPath(node.left);
        getPath(node.right);
        path.remove(path.size()-1);
    }
}
----------------------------------------------------------------
public class Solution {
    List<String> result = new LinkedList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        childBinaryTreePath(root, "");

        return result;
    }

    public void childBinaryTreePath(TreeNode root, String path) {
        path += root.val;

        if (root.left == null && root.right == null) {
            result.add(path);
        } 
        if (root.left != null) {
            childBinaryTreePath(root.left, path + "->");
        }
        if (root.right != null) {
            childBinaryTreePath(root.right, path + "->");
        }
    }
}