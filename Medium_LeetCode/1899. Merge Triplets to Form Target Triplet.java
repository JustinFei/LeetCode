class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = new int[3];
        for (var s : triplets)
            if (s[0] <= target[0] && s[1] <= target[1] && s[2] <= target[2])
                res = new int[]{ Math.max(res[0], s[0]), Math.max(res[1], s[1]), Math.max(res[2], s[2]) };
        return Arrays.equals(res, target);
    }
}