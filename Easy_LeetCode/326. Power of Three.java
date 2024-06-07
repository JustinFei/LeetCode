public boolean isPowerOfThree(int n) {
    return n > 0 && (int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3.0))) % n == 0;
}
----------------------------------------------
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        while (n >= 3){
            if (n%3 == 0 && n!=3) {
                n /= 3;
            } else{
               n %= 3;
            }
        }
        return n==0? true:false;
    }
