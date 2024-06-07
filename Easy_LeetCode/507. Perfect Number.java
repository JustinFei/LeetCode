public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int res = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                res += i + num / i;
            }
        }
        res++;
        return res == num;
    }
}