class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder t = new StringBuilder();
        for(String w : words) {
            t.append(w);
            if(t.toString().equals(s))
                return true;
            if(t.length() > s.length())
                return false;
        }
        return false;
    }
}