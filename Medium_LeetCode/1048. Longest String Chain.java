class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        // Arrays.sort(words,new Comparator<String>()
        // {
        //   public int compare(String s1,String s2)
        //    {
        //     return s1.length() - s2.length();
        //     }
        // });
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] count = new int[n];
        int res= 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    count[i] = Math.max(count[i], count[j] + 1);
                    res = Math.max(res, count[i]);
                }
                
            }
        }
        return res + 1;
    }
    
    private boolean isPredecessor(String s, String t) {
        if (t.length() - s.length() != 1) {
            return false;
        }
        
        boolean flag = false;
        int i = 0, j = 0;
        while (i < s.length() & j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else if (flag) {
                return false;
            } else {
                flag = true;
                j++;
            }
        }
        return true;
    }
}

//----------------------------------------------
public int longestStrChain(String[] words) {
    Map<String, Integer> dp = new HashMap<>();
    Arrays.sort(words, (a, b)->a.length() - b.length());
    int res = 0;
    for (String word : words) {
        int best = 0;
        for (int i = 0; i < word.length(); ++i) {
            String prev = word.substring(0, i) + word.substring(i + 1);
            best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
        }
        dp.put(word, best);
        res = Math.max(res, best);
    }
    return res;
}