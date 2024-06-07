class Solution {
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<>();
        char[] v = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char c: v) {
            vowel.add(c);
        }
        String[] array = S.trim().split(" ");
        int count = 1;
        String res = "";
        for (String s : array) {
            s = s.trim();
            if (s.length() == 0) continue;
            if (vowel.contains(s.charAt(0))) {
                s += "ma";
            } else {
                s += s.charAt(0);
                s = (s.substring(1) + "ma");
            }
            for (int i = 0; i < count; i++) {
                s += 'a';
            }
            res += (s + " ");
            count++;   
        }
        res.deleteCharAt(res.length() - 1);
        return res;
    }
}