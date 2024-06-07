public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        else if (num2 == null || num2.length() == 0) return num1;
        StringBuilder res = new StringBuilder();
        int flag = 0;
       for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || flag == 1; i--, j--) {
           int a = i < 0 ? 0 : num1.charAt(i) - '0';
           int b = j < 0 ? 0 : num2.charAt(j) - '0';
           int cur = a + b + flag;
           sb.append(cur % 10);
           flag = cur / 10;
       }
       return res.reverse().toString();
    }
}