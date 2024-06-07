class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int num: nums) {
            int sum = 0;
            // Get the digit sum
            for(int k = num; k > 0; k /= 10) {
                sum += k % 10;
            }
            if (!map.containsKey(sum)) map.put(sum, num);
            else {
                max = Math.max(max, map.get(sum) + num);
                map.put(sum, Math.max(num, map.get(sum)));
            }
        }

        return max;
    }

    // private int getSum(int num) {
    //     int n = 0;
    //     while (num > 0) {
    //         n += num % 10;
    //         num /= 10;
    //     }
    //     // for (char digit: String.valueOf(num).toCharArray()) {
    //     //     n += Integer.valueOf(digit - '0');
    //     // }
    //     return n;
    // }
}

// ---------------------------------------------------

class Solution {
    public int maximumSum(int[] nums) {
        int max = -1;
        int[] patterns = new int[91]; // All possible patterns

        for(int n : nums) {
            int sum = 0;
            // Get the digit sum
            for(int k = n; k > 0; k /= 10) {
                sum += k % 10;
            }

            if (patterns[sum] == 0) {
                patterns[sum] = n;
            } else {
                max = Math.max(max, patterns[sum] + n);
                patterns[sum] = Math.max(patterns[sum], n);
            }
        }

        return max;
    }
}