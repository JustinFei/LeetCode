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
       List<List<Integer>> ll = new LinkedList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        int d = 0;
        input(root,d);
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        for(int i=0;i<ll.size();i++){
            re.add(ll.get(i));
        }
        return re;
    }
    public List<List<Integer>> input(TreeNode root, int d){
        if(root!=null){
            if(ll.size()<d+1){
                List<Integer> l = new LinkedList<Integer>();
                ll.add(l);
            }
         ll.get(d).add(root.val);
            input(root.left,d+1);
            input(root.right,d+1);
        }
        return ll;
    }
}
------------------------------------------------------
//My Java 2 solutions 1ms(dfs) & 2ms(bfs)
​
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode t = q.poll();
                if (t.left != null)
                    q.offer(t.left);
                if (t.right != null)
                    q.offer(t.right);
                tmp.add(t.val);
            }
            res.add(tmp);
        }
        return res;
    }
}


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res,root,0);
        return res;
    }
    public void dfs(List<List<Integer>> list,TreeNode node,int deep){
        if(node==null)return;
        if(list.size()==deep)
            list.add(new ArrayList<Integer>());
        list.get(deep).add(node.val);
        dfs(list, node.left, deep+1);
        dfs(list, node.right, deep+1);    
    }
}