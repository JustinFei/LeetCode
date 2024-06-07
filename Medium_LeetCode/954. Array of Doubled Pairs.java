class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int a: arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        for (int x : map.keySet()) {
            if (map.get(x) == 0) continue;
            int want = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || map.get(x) > map.getOrDefault(want, 0)) {
                return false;
            }
            map.put(want, map.get(want) - map.get(x));
        }
        return true;
    }
}