class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() < words[0].length() * words.length) {
            return res;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int n = words[0].length();
        int tn = words[0].length() * words.length;
        String cur;
        int left = 0;
        int right = 0;
        Integer mapNumber;
        Integer tmpNumber;
        int match;
        Map<String, Integer> tmp = new HashMap<String, Integer>();
        for (int i = 0; i <= s.length() - tn; i++) {
            left = i;
            right = i;
            tmp.clear();
            mapNumber = null;
            tmpNumber = null;
            match = 0;
            while (right <= i + tn - n) {
                cur = s.substring(right, right + n);
                mapNumber = map.get(cur);
                if (mapNumber != null) {
                    tmpNumber = tmp.getOrDefault(cur, 0) + 1;
                    if (mapNumber.equals(tmpNumber)) {
                        match++;
                    } else if (tmpNumber > mapNumber) {
                        break;
                    }
                    tmp.put(cur, tmpNumber);
                    right += n;
                } else {
                    break;
                }
            }
            if (match == map.size()) {
                res.add(left);
            }
        }
        return res;
    }
}