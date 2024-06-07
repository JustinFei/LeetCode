class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int res = 0;
        for (int curUnique = 1; curUnique <= maxUnique; curUnique++) {
            Arrays.fill(countMap, 0);
            int start = 0, end = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while (end < str.length) {
                if (unique <= curUnique) {
                    idx = str[end] - 'a';
                    if (countMap[idx] == 0) {
                        unique++;
                    }
                    countMap[idx]++;
                    if (countMap[idx] == k) {
                        countAtLeastK++;
                    }
                    end++;
                } else {
                    idx = str[start] - 'a';
                    if (countMap[idx] == k) countAtLeastK--;
                    countMap[idx]--;
                    if (countMap[idx] == 0) {
                        unique--;
                    }
                    start++;
                }
                if (unique == curUnique && unique == countAtLeastK) {
                    res = Math.max(res, end - start);
                }
            }
        }
        return res;
    }
    
    private int getMaxUniqueLetters(String s) {
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}