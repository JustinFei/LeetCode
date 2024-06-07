class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] JArr = J.toCharArray();
        HashSet<Character> hash = new HashSet<>();
        for(char c: JArr) {
            hash.add(c);
        }
        int res = 0;
        char[] SArr = S.toCharArray();
        for (char c: SArr) {
            if (hash.contains(c)) {
                res++;
            }
        }
        return res;
    }
}