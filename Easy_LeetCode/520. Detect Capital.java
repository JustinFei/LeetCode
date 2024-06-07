public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() <= 1) return true;
        int cnt = 0;
        for (char c: word.toCharArray()) {
            if ('Z' - c >= 0) cnt++;
        }
        return cnt == 0 || cnt == word.length() || (cnt == 1 && 'Z' - word.charAt(0) >= 0);
    }
}

//----------------------------------------------
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        if (Character.isUpperCase(word.charAt(0))) {
            boolean f = Character.isUpperCase(word.charAt(1));
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i)) != f) {
                    return false;
                } 
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
//--------------------------------------------
public boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;
        if (word.toUpperCase().equals(word)) return true;
        if (word.substring(1).toLowerCase().equals(word.substring(1))) return true;
        return false;
}