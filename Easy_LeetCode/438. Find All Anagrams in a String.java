public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>  result = new ArrayList<>();
        if (s == null || s.length() < p.length()) return result;
        Map<Character, Integer> map = getMap(p);
        int match = 0;
        char[] sa = s.toCharArray(); 
        int length = p.length();
        for (int i = 0; i < sa.length; i++) {
            Integer cIn = map.get(sa[i]);
            if (cIn != null) {
                map.put(sa[i], cIn - 1);
                if (cIn == 1) {
                    match++;
                }
            }
            if (i >= length) {
                Integer cOut = map.get(sa[i - length]); 
                if (cOut != null) {
                    map.put(sa[i - length], cOut + 1);
                    if (cOut == 0) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - length + 1);
            }
        }
        return result;
    }
    private Map<Character, Integer> getMap(String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            Integer cnt = map.get(p.charAt(i));
            if (cnt != null) {
                map.put(p.charAt(i), cnt + 1);
            } else {
                map.put(p.charAt(i), 1);
            }
        }
        return map;
    }
}