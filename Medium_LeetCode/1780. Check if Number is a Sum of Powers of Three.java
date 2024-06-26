// think of n in ternary form
// each digit is 3^i, and ternary number is sum of them
// to have distinct powers of 3 to sum up n:
//  digit can be 0 i.e. no such number
//  digit can be 1 i.e. one such number
// a digit cannot be 2 because then there is 2 of 3^i, therefore not distinct

// n mod 3 to get right-most digit
// n divide by 3 to right shift once and go to next digit

class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {         // calculation finish once reach 0, reached 3^0
            if (n % 3 == 2)
                return false;   // mod remainder 2 will not have distinct sum
            n /= 3;             // right shift ternary bits by 1 is divide by 3
        }
        return true;
    }
}