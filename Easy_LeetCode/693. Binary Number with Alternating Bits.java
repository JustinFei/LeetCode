class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean flag;
        if (n % 2 == 0) flag = false;
        else flag = true;
        while (n > 0) {
            if (((n & 1) == 1 && flag == false ) || ( (n & 1) == 0 && flag == true))
                return false;
            n /= 2;
            flag = (flag == true ? false : true);
        }
        return true;
    }
}
//
class Solution {
    public boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);
        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}