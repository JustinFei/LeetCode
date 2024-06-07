class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        int[] map = new int[26];
        int n = S.length();
        for (int i = 0; i < n; i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        return res;
    }
}