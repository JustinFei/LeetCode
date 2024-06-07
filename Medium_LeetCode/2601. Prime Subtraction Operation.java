class Solution {
    private boolean isPrime(int x) {
        if (x == 1) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean primeSubOperation(int[] nums) {
        int prev = 0;

        for (int num : nums) {
            if (num <= prev) {
                return false;
            }

            int prime = num - prev - 1;
            while (prime > 0 && !isPrime(prime)) {
                prime--;
            }

            if (prime == 0) {
                prev = num;
            } else {
                prev = num - prime;
            }
        }

        return true;
    }
}