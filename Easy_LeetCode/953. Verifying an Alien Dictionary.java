class Solution {
    int[] mapping = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            mapping[order.charAt(i) - 'a'] = i;
        }
            
        for (int i = 0; i < words.length - 1; i++)
            if (bigger(words[i], words[i + 1]))
                return false;
        return true;
    }

    boolean bigger(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        for (int i = 0; i < m && i < n; i++)
            if (s1.charAt(i) != s2.charAt(i))
                return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
        return m > n;
    }
}