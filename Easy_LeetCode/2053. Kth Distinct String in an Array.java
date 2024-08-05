class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Boolean> map = new HashMap<>();
        for (String s : arr) map.put(s, map.containsKey(s) ? false : true);
        int count = 0;
        for (String s : arr) {
            if (map.get(s)) {
                count++;
                if (count == k) return s;
            }
        }
        return "";
    }
}