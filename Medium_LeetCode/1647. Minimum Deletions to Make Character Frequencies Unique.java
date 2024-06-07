class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        int res = 0;
        for (char c: s.toCharArray()) {
            cnt[c - 'a']++;
        }

        Set<Integer> set = new HashSet<>();
        for (int frq: cnt) {
            while (frq > 0) {
                if (!set.contains(frq)) {
                    set.add(frq);
                    break;
                }
                frq--;
                res++;
            }
        }
        return res;
    }
}