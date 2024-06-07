class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        backtracking(0, s, set, new StringBuilder(), res);
        return res;
    }

    private void backtracking(int start, String s, Set<String> set, StringBuilder sb, List<String> res) {
        if (start == s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        StringBuilder cur = new StringBuilder();
        String sub;
        for (int i = start; i < s.length(); i++) {
            cur.append(s.charAt(i));
            sub = cur.toString();
            if (set.contains(sub)) {
                sb.append(sub).append(' ');
                backtracking(i + 1, s, set, sb, res);
                sb.setLength(sb.length() - sub.length() - 1);
            }
        }
    }
}