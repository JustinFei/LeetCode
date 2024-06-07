class Solution {
    public String reformat(String s) {
        List<Character> l = new ArrayList<>();
        List<Character> d = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                l.add(s.charAt(i));
            } else {
                d.add(s.charAt(i));
            }
        }
        if (Math.abs(d.size() - l.size()) > 1) {
            return "";
        }
        boolean dOrl = d.size() - l.size() >= 0 ? true : false;
        int di = 0, li = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (dOrl) {
                sb.append(d.get(di));
                di++;
            } else {
                sb.append(l.get(li));
                li++;
            }
            dOrl = !dOrl;
        }
        return sb.toString();
    }
}