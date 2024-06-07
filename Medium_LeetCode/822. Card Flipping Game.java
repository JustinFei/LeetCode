class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> same = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                same.add(fronts[i]);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int f : fronts)
            if (!same.contains(f))
                res = Math.min(res, f);

        for (int b : backs)
            if (!same.contains(b))
                res = Math.min(res, b);

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}