class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int slow = 0;
        Set<Character> set = new HashSet<>();
        int res = 1;
        set.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            while (!set.add(s.charAt(i))) {
                set.remove(s.charAt(slow++));
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}