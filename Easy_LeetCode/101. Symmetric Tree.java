public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode a,TreeNode b){
        return a==null||b==null?a==b:a.val==b.val&&isMirror(a.left,b.right)&&isMirror(a.right,b.left);
    }
}