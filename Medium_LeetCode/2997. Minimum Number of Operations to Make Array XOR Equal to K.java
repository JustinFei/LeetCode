
class Solution {
    public int minOperations(int[] nums, int k) {
        int cur = 0, res = 0;
        for (int num : nums) {
            cur ^= num;
        }

        while (k > 0 || cur > 0) {
            if (k % 2 != cur % 2) res++;
            k /= 2;
            cur /= 2;
        }

        return res;
    }
}

// ---- My solution, not good -----------------------

class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        int[] count = new int[32];
        int[] target = new int[32];

        for (int i = 0; i < 32; i++) target[i] = (k >> i) & 1;

        for (int num : nums)
            for (int i = 0; i < 32; i ++)
                count[i] += (num >> i) & 1;

        for (int i = 0; i < 32; i++)
            if (target[i] % 2 != count[i] % 2) 
                res++;

        return res;
    }
}