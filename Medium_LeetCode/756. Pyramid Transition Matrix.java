class Solution {
    boolean pyramidTransition(String bottom, List<String> allowed) {   
        Map<String, Set<Character>> map = new HashMap<>();
        for (String s : allowed) {
            map.computeIfAbsent(s.substring(0, 2), k -> new HashSet<>()).add(s.charAt(2));
        }
        char[] above = new char[bottom.length()];
        return helper(bottom, above, 0, map);
    }
    boolean helper(String cur, char[] above, int index, Map<String, Set<Character>> map) {
        if (cur.length() == 2 && index == 1) return true;
        if (index == cur.length() - 1) {
            return helper(new String(above, 0, index), above, 0, map);
        } 
        String base = cur.substring(index, index + 2);

        for(char ch : map.getOrDefault(base, new HashSet<>())) {
            above[index] = ch;
            if(helper(cur, above, index + 1, map)) return true;
        }
        return false;
    }
}