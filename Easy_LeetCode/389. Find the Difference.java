public class Solution {
    public char findTheDifference(String s, String t) {
        int charCodeS = 0;
        int charCodeT = 0;
        for(char c:s.toCharArray()) {
            charCodeS += (int) c;
        }
        for(char c:t.toCharArray()) {
            charCodeT += (int) c;
        }
        return (char) (charCodeT - charCodeS);
    }
}