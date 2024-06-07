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
    List<List<Integer>> ll = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int depth = 0;
        input(root, depth);
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        int n = ll.size() - 1;
        for(int i = 0; i<=n; i++){
            re.add(ll.get(n-i));
        }
        return re;
    }
    
    public void input(TreeNode root, int depth){
        if(root != null){
            if(ll.size()<depth+1){
                List<Integer> l = new ArrayList<Integer>();
                ll.add(l);
            }
            ll.get(depth).add(root.val);
            input(root.left, depth+1);
            input(root.right, depth+1);
        }
    }
}