class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> rep = new HashSet<>();
        if (s == null || s.length() <= 10) {
            return new ArrayList<String>(rep);
        }
        String tmp;
        for (int i = 0; i < s.length() - 9; i++) {
            tmp = s.substring(i, i + 10);
            if (set.contains(tmp)) {
                rep.add(tmp);
            }
            set.add(tmp);
        }
        return new ArrayList<String>(rep);
    }
}