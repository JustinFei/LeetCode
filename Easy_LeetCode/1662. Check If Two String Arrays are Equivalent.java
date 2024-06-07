class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int sum1 = 0, sum2 = 0;
        for (String s: word1) {
            sum1 += s.length();
        }
        
        for (String s: word2) {
            sum2 += s.length();
        }
        
        if (sum1 != sum2) {
            return false;
        }
        int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
        while (r1 < word1.length && r2 < word2.length) {
            while (c1 < word1[r1].length() && c2 < word2[r2].length()) {
                if (word1[r1].charAt(c1++) != word2[r2].charAt(c2++)) {
                    return false;
                }
            }
            if (c1 == word1[r1].length() && c2 == word2[r2].length()) {
                r1++;
                r2++;
                c1 = 0;
                c2 = 0;
            } else if (c1 == word1[r1].length()) {
                r1++;
                c1 = 0;
            } else {
                r2++;
                c2 = 0;
            }
        }
        return true;
    }
}

// ---------------------

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for(String word: word1)
            sb1.append(word);
        
        for(String word: word2)
            sb2.append(word);
        
        return sb1.toString().equals(sb2.toString());
    }
}

// ----------------

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}