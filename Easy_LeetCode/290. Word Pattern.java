class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, Integer> pMap = new HashMap<>();
        Map<String, Integer> sMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = words[i];
            if((pMap.containsKey(c) ^ sMap.containsKey(s))
                ||(pMap.containsKey(c) && sMap.containsKey(s) && pMap.get(c) != sMap.get(s))) return false;
            pMap.put(c, i);
            sMap.put(s, i);
        }
        return true;
    }
}
//------------------------------
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c) && !map.get(c).equals(strs[i])) {
                return false;
            } else if (!map.containsKey(c) && set.contains(strs[i])) {
                return false;
            } else {
                map.put(c, strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }
}