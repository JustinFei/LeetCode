class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) 
            map.put(s, map.getOrDefault(s, 0) + 1);

        int res = 0;
        boolean flag = false;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int countOfTheWord = entry.getValue();
            // if the word is a palindrome
            if (word.charAt(0) == word.charAt(1)) {
                if (countOfTheWord % 2 == 0) {
                    res += countOfTheWord;
                } else {
                    res += countOfTheWord - 1;
                    flag = true;
                }
            // consider a pair of non-palindrome words such that one is the reverse of another
            } else if (word.charAt(0) < word.charAt(1)) {
                String reversedWord = "" + word.charAt(1) + word.charAt(0);
                if (map.containsKey(reversedWord)) {
                    res += 2 * Math.min(countOfTheWord, map.get(reversedWord));
                }
            }
        }
        if (flag) {
            res++;
        }
        return 2 * res;
    }
}