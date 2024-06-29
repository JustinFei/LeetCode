class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList();
        List<List<Integer>> directChild = new ArrayList();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList());
            directChild.add(new ArrayList());
        }
        for (int[] e: edges)  directChild.get(e[0]).add(e[1]);
        for (int i = 0; i < n; i++) dfs(i, i, res, directChild);
        return res;
    }

    private void dfs(int x, int curr, List<List<Integer>> res, List<List<Integer>> directChild) {
        for (int ch: directChild.get(curr))
            if(res.get(ch).size() == 0 || res.get(ch).get(res.get(ch).size() - 1) != x) {
                res.get(ch).add(x);
                dfs(x, ch, res, directChild);
            }
    }
}