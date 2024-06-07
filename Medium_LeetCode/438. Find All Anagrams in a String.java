class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        if (p.length() > s.length()) {
            return res;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int left = map.size();
        int n = p.length();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            Integer tmp = map.get(cur);
            if (tmp != null) {
                map.put(cur, tmp - 1);
                
                if (tmp == 1) {
                    left--;
                }
            }
            
            
            if (i >= n) {
                char pre = s.charAt(i - n);
                Integer tmp2 = map.get(pre);
                if (tmp2 != null) {
                    map.put(pre, tmp2 + 1);
                    
                    if (tmp2 == 0) {
                        left++;
                    }
                }
            }
            if (left == 0) {
                res.add(i - n + 1);
            }
        }
        return res;
    }
}