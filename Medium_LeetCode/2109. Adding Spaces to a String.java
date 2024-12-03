class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, m = s.length(), n = spaces.length;
        while (j < n) {
            while (i < spaces[j]) {
                sb.append(s.charAt(i++));
            }
            sb.append(' ');
            j++;
            sb.append(s.charAt(i++));
        }
        while (i < m) {
            sb.append(s.charAt(i++));
        }
        return sb.toString();
    }
}

// --------------------------

class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int index = 0;

        for(int i : spaces){
                sb.append(s.substring(index , i)).append(" ");
                index = i;
        }
        sb.append(s.substring(index , s.length()));
        return sb.toString();
    }
}