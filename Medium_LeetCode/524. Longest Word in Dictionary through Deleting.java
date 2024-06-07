class Solution {
    public String findLongestWord(String s, List<String> d) {
        String max = "";
        int i;
        char[] array = s.toCharArray();
        for (String t: d) {
            i = 0;
            for (char c: array) {
                if (i < t.length() && t.charAt(i) == c) {
                    i++;
                }
            }
            if (i == t.length() && i >= max.length()) {
                if (i > max.length() || t.compareTo(max) < 0) {
                    max = t;
                }
            }
        }
        return max;
    }
}

//------------------------------------------------------------


class Solution {
    public String findLongestWord(String s, List<String> d) {
        List<String> res = new ArrayList<>();
        int curMax = 0;
        int curS, curT;
        for (String t: d) {
            curS = 0;
            curT = 0;
            while (curS < s.length() && curT < t.length()) {
                if (s.charAt(curS) == t.charAt(curT)) {
                    curS++;
                    curT++;
                } else {
                    curS++;
                }
            }
            if (curT == t.length() && curT >= curMax) {
                if (curT > curMax) {
                    curMax = curT;
                    res.clear();
                }
                res.add(t);
            }
        }
        Collections.sort(res);
        return res.size() > 0 ? res.get(0) : "";
    }
}