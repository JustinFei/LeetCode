/*
    Each time increment a, then OR with x,
    So we get the next bigger valid element.

    We do this n - 1 times,
    and return the result.

    Time O(n)
    Space O(1)

*/

class Solution {
    public long minEnd(int n, int x) {
        long a = x;
        while (--n > 0) {
            a = (a + 1) | x;
        }

        return a;
    }
}

// ------------------------

/*
    O(n) is only accepted in C++ and Java.
    We can split all bits of n - 1
    and fill them into empty bits of x.

    Time O(70)
    Space O(1)

    n-1 is done because x is already the first element, we need to find the other n-1 elements.
    When an empty bit in x is found, we have 2 choices, leave it empty or fill it. The same applies for every empty bit. So, 2∗2∗2..=n−1=>2 
    k=n−1=>k=log2 (n−1). This is why n >>= 1 is being done for each empty bit.
    If the 1st bit of n is on, the bth bit of x will be turned on. This is achieved with x |= (n & 1) * b.
    Lastly, 64 iterations should not be necessary. 10^8 ~= 2^26 (2^27 > 10^8). So, 2^26 is the maximum starting value for x. With n set to 10^8, the maximum bits in the final number can't be more than 26 + 27 = 53.


*/


class Solution {
    public long minEnd(int n, int x) {
        n--;
        long a = x;
        for (long b = 1; n > 0; b <<= 1) {
            if ((b & x) == 0) {
                a |= (n & 1) * b;
                n >>= 1;
            }
        }
        return a;
    }
}