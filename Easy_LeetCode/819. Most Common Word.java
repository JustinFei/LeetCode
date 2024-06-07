class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (String b: banned) set.add(b);
        String res = "";
        int max = 0;
        String[] array = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
        for (String s: array) {
            if (set.contains(s)) {
                continue;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (max < map.get(s)) {
                max = map.get(s);
                res = s;
            }
        }
        return res;
    }
}