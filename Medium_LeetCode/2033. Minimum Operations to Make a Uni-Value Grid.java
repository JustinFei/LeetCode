class Solution {
    public int minOperations(int[][] grid, int x) {
        // ArrayList<Integer> array = new ArrayList<>();
        int[] array = new int[grid.length * grid[0].length];
        int index = 0;
        for (int[] row : grid) {
            for (int a : row) {
                // array.add(a);
                array[index++] = a;
            }
        }

        // Sort numsArray in non-decreasing order to easily find the median
        // Collections.sort(array);
        Arrays.sort(array);

        // Store the median element as the final common value
        // int l = array.size(), m = array.get(l / 2);
        int l = array.length, m = array[l / 2];

        int res = 0;
        for (int num : array) {
            // If the remainder when divided by x is different, return -1
            if (num % x != m % x) return -1;

            // Add the number of operations required to make the current number equal to finalCommonNumber
            res += Math.abs(num - m) / x;
        }

        return res;
    }
}