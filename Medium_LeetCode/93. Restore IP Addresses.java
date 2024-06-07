class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(0, new StringBuilder(), s, 0, result);
        return result;
    }


    public void backtrack(int index, StringBuilder sb, String s, int prevIndex, List<String> result) {
        if (index == 4) {
            if (sb.length() == index + s.length()) {
                result.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }

        for (int i = prevIndex + 1; i <= s.length() && i < prevIndex + 4; i++) {
            String sub = s.substring(prevIndex, i);
            if (sub.length() > 1 && sub.charAt(0) == '0') {
                return;
            }
            int x = Integer.parseInt(sub);
            if (x >= 0 && x < 256) {
                sb.append(sub);
                sb.append(".");
                backtrack(index + 1, sb, s, i, result);
                sb.delete(sb.length() - sub.length() - 1, sb.length());
            }
        }
    }
}