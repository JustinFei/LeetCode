class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int diff = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
        Set<Integer> set = new HashSet<>();
        for (int a : A) set.add(a);
        for (int b : B) if (set.contains(b + diff)) return new int[]{b + diff, b};
        return new int[0];
    }
}