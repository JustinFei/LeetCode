class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a: A) {
            if (!set.add(a)) {
                return a;
            }
        }
        return -1;
    }
}