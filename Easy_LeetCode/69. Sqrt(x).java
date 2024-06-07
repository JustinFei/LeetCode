class Solution {
    public int mySqrt(int x) {
         return (int) Math.floor(Math.sqrt(x));
    }
}

// ------------------------------------------------------------
class Solution {
 private int binarySearch(long low, long high, int x) {        
        if (low == high)
            return (int)low;
        long mid = (high + low) / 2;
        if ((mid * mid == x) || (low == mid))
            return (int)mid;
        else if (mid * mid > x)
            return binarySearch(low, mid, x);
        else
            return binarySearch(mid, high, x);
    }
    
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        return binarySearch(1, x, x);
    }
}