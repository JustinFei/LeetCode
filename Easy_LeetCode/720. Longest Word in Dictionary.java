class Solution {
    public String longestWord(String[] words) {
        String res = "";
        Set<String> set = new HashSet<>();
        Arrays.sort(words);
        for (String w: words) {
            if (w.length() == 1 || set.contains(w.substring(0, w.length() - 1))) {
                set.add(w);
                res = w.length() > res.length() ? w : res;
                
            }
        }
                return res;
    }
}