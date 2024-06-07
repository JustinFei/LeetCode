class Solution {
    public String firstPalindrome(String[] words) {
        if (words == null || words.length == 0) return "";
        for (String word : words)
            if (isPalindrome(word))
                return word;
        return "";
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        return true;
    }
}