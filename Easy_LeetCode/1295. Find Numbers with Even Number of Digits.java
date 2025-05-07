class Solution {
    public int findNumbers(int[] nums) {
        int res = 0, digitCount = 0;
        for (int num : nums) {
            digitCount = 0;
            while (num != 0) {
                digitCount++;
                num /= 10;
            }
            res += (digitCount & 1) == 0 ? 1 : 0;
        }

        return res;
    }
}

// ------------------------

class Solution {
    public int findNumbers(int[] nums) {
        // Counter to count the number of even digit integers
        int evenDigitCount = 0;

        for (int num : nums) {
            // Convert num to string and find its length
            int length = String.valueOf(num).length();
            if (length % 2 == 0)
                evenDigitCount++;
        }

        return evenDigitCount;
    }
}

// ------------------------

class Solution {
    public int findNumbers(int[] nums) {
        // Counter to count the number of even digit integers
        int evenDigitCount = 0;

        for (int num : nums) {
            // Compute the number of digits in the num
            int digitCount = (int) Math.floor(Math.log10(num)) + 1;
            if (digitCount % 2 == 0)
                evenDigitCount++;
        }

        return evenDigitCount;
    }
}

// -------------------

class Solution {
    public int findNumbers(int[] nums) {
        // Counter to count the number of even digit integers
        int evenDigitCount = 0;

        for (int num : nums) {
            if ((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || num == 100000)
                evenDigitCount++;
        }

        return evenDigitCount;
    }
}