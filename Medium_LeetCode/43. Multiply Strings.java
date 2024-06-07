public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j; 
                int p2 = i + j + 1;
                
                int sum = mult + res[p2];
                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit: res) {
            if (sb.length() == 0 && digit == 0) continue;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}