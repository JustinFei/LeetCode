class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] lastPosition = new int[10];

        for (int i = 0; i < digits.length; i++) {
            lastPosition[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {
                 // Compare the digit index, if the index is bigger,
                 // it means it's behind. We should swap it.
                if (lastPosition[j] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[lastPosition[j]];
                    digits[lastPosition[j]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
    }
}