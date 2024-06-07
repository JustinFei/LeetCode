class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (String word: words) {
            res += countCharacters(word, map);
        }
        return res;
    }
    
    private int countCharacters(String word, Map<Character, Integer> map) {
        Map<Character, Integer> copy = new HashMap<Character, Integer>(map);
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            Integer n = copy.get(tmp);
            if (n == null || n == 0) {
                return 0;
            } else {
                copy.put(tmp, n - 1);
            }
        }
        return word.length();
    }
}

// -------------------------------------------------------------------------

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for (Character c: chars.toCharArray()) {
            counts[c - 'a']++;
        }

        int res = 0;
        int[] curWordCount;
        boolean good;
        for (String word : words) {
            curWordCount = new int[26];
            for (Character c: word.toCharArray()) {
                curWordCount[c - 'a']++;
            }

            good = true;
            for (int i = 0; i < 26; i++) {
                if (curWordCount[i] > counts[i]) {
                    good = false;
                    break;
                }
            }

            if (good) res += word.length();
        }

        return res;
    }
}