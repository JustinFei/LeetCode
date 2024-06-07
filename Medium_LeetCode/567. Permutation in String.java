class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.keySet().size();
        int n1 = s1.length();
        
        for (int i = 0; i < s2.length(); ++i) {
            char c = s2.charAt(i);
            
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                }
            }
            
            if (i >= s1.length()) {
                c = s2.charAt(i - s1.length());
                if (map.containsKey(c)) {
                    if (map.get(c) == 0) {
                        count++;
                    }
                    map.put(c, map.get(c) + 1);
                }
            }

            if (count == 0) { 
                return true;
            }
        }
        return false;
    }
}