class Solution {
    public String largestGoodInteger(String num) {
        char c = '0';
        boolean flag = false;
        for (int i = 1; i < num.length() - 1; i++) {
            if (num.charAt(i - 1) == num.charAt(i) && num.charAt(i) == num.charAt(i + 1)) {
                flag = true;
                if (num.charAt(i) > c) 
                    c = num.charAt(i);
            }
        }

        return flag ? new String(new char[]{c, c, c}) : "";
    }
}