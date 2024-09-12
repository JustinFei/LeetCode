class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Set<Character> set = new HashSet<>();
        // for (char c : allowed.toCharArray()) set.add(c);
        // return Arrays.stream(words)
        //             .mapToInt(w -> w.chars().allMatch(c -> set.contains((char)c)) ? 1 : 0)
        //             .sum();

        int res = 0;
        boolean[] f = new boolean[26];
        for (char c : allowed.toCharArray()) f[c - 'a'] = true;
        for (String word : words) if (check(word, f)) res++;

        return res;
    }

    private boolean check(String s, boolean[] f) {
        for (int i = 0; i < s.length(); i++) 
            if (!f[s.charAt(i) - 'a']) 
                return false;
        return true;
    }
}