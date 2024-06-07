public boolean isPowerOfTwo(int n) {
    if(n<=0)
        return false;
    if(Integer.bitCount(n)==1)
        return true;
    return false; 
}
--------------------------------
public class Solution {
    public boolean isPowerOfTwo(int n) {
    /**
     * There is two accepted answers,the former is better.
     */
    return n <= 0 ? false : (n & (n - 1)) == 0;
    // return n <= 0 ? false : n == Math.pow(2, (int) (Math.log(n) / Math.log(2)));
    }
}