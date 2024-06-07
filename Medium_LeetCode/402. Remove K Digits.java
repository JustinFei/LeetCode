class Solution {
    public String removeKdigits(String num, int k) {
        if (num == "0") {
            return num;
        }
        if (num.length() == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        int i = 1;
        while (k > 0 && i < sb.length()) {
            if (sb.charAt(i - 1) > sb.charAt(i)) {
                sb.deleteCharAt(i - 1);
                k--;
                i--;
                if (i == 0) {
                    i = 1;
                }
            } else {
                i++;
            }
        }
        i = sb.length() - 1;
        while (k > 0) {
            sb.deleteCharAt(i--);
            k--;
        }
        
        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
        
    }
}