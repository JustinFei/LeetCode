public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int digitA = i < 0 ? 0 : a.charAt(i--) - '0';
            int digitB = j < 0 ? 0 : b.charAt(j--) - '0';
            sum.insert(0, (digitA + digitB + carry) % 2);
            carry = (digitA + digitB + carry) / 2;
        }
        return sum.toString();
    }
}
--------------------------------------
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = a.length(), j = b.length();
        while (i > 0 || j > 0 || carry == 1) {
            if (i > 0)
                carry += a.charAt(--i) - '0';
            if (j > 0)
                carry += b.charAt(--j) - '0';
            sb.append((char) ((carry % 2) + '0'));
            carry >>>= 1;
        }
        return sb.reverse().toString();
    }
}
-------------------------
class Solution {
    public String addBinary(String a, String b) {
                int c = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0;i--,j--){
            if(i >= 0) c += a.charAt(i) - '0';
            if(j >= 0) c += b.charAt(j) - '0';
            sb.insert(0, (char)((c % 2) + '0'));
            c /= 2;
        }
        if(c == 1) sb.insert(0, "1");
        return sb.toString();
    
    }
}