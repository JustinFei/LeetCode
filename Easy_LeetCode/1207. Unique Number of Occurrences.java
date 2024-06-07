class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int a: arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int v: map.values()) {
            if (!set.add(v)) {
                return false;
            }
        }
        return true;
    }
}
//---------------
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        return count.size() == new HashSet<>(count.values()).size();
    }
}