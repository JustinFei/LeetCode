class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int s: salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return (double)(sum - max - min) / (n - 2);
    }
}