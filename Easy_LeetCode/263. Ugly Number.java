public boolean isUgly(int num) {
    if(num <= 0) return false;
    while(num % 2 == 0) num /= 2;
    while(num % 3 == 0) num /= 3;
    while(num % 5 == 0) num /= 5;
    return num == 1;
}
-----------------------------
public class Solution {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        int[] divisors = {2, 3, 5};
        for (int divisor : divisors) {
            while(num % divisor == 0) {
                num /= divisor;
            }
        }
        return num == 1;
    }
}