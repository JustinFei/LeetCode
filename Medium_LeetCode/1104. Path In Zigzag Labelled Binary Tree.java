class Solution {
     public List<Integer> pathInZigZagTree(int label) {
        int level = 0;
        while (1 << level <= label) {
            level++;
        }
        
        LinkedList<Integer> res = new LinkedList<>();
        int parent = label;
        
        while (parent > 0) {
            res.addFirst(parent);
            int offSet = (1 << level) - 1 - parent;
            parent = ((1 << (level - 1)) + offSet) / 2;
            level--;
        }
        
        return res;
     }
}