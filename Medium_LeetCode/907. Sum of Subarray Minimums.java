class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        // long mod = 1e9 + 7;
        long sum = 0;

        Stack<Integer> stack = new Stack<>();

        int j, k;
        // left = j - k;
        // right = i - j;


        for (int i = 0; i <= arr.length; i++) {
            while (!stack.isEmpty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {
                j = stack.pop();
                k = stack.isEmpty() ? - 1 : stack.peek();
                sum += (long) arr[j] * (i - j) * (j - k);
                sum %= mod;
            }
            stack.push(i);
        }

        return (int) sum % mod; 
    }
}