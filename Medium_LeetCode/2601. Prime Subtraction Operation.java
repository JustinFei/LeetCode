class Solution {
    private boolean isPrime(int x) {
        if (x == 1) return false;

        for (int i = 2; i * i <= x; i++)
            if (x % i == 0)
                return false;

        return true;
    }

    public boolean primeSubOperation(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        int candidate, prev = 0;
        for (int num : nums) {
            if (num <= prev) return false;

            candidate = num - prev - 1;
            while (candidate > 0 && !isPrime(candidate)) candidate--;

            prev = num - candidate;
        }

        return true;
    }
}