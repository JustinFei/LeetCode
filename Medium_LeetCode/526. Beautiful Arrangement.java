class Solution { // Approach #1 Brute Force [Time Limit Exceeded]
    int count = 0;
    public int countArrangement(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        permute(nums, 0);
        return count;
    }
    
    private void permute(int[] nums, int l) {
        if (l == nums.length - 1) {
            int i = 1;
            for (; i<= nums.length; i++) {
                if (nums[i - 1] % i != 0 && i % nums[i - 1] != 0) {
                    break;
                }
            }
            if (i == nums.length + 1) {
                count++;
            }
        }
        for (int i = l; i < nums.length; i++) {
            swap(nums, i, l);
            permute(nums, l + 1);
            swap(nums, i, l);
        }
    }
    
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

//--------------------------------------
class Solution { // Time complexity : O(k)O(k). kk refers to the number of valid permutations. Space complexity : O(n)O(n).
    int count = 0;
    public int countArrangement(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        permute(nums, 0);
        return count;
    }
    
    private void permute(int[] nums, int l) {
        if (l == nums.length) {
            count++;
        }
        for (int i = l; i < nums.length; i++) {
            swap(nums, i, l);
            if (nums[l] % (l + 1) == 0 || (l + 1) % nums[l] == 0)
                permute(nums, l + 1);
            swap(nums, i, l);
        }
    }
    
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
//-----------------------
class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        helper(n, 1, visited);
        return count;
    }
    
    private void helper(int n, int pos, boolean[] visited) {
        if (pos > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                helper(n, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}