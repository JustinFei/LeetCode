class Solution { // O(n ^ 2) O(1)
    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }
}

//-----------------

class Solution { // O(n) O(n)
    public int numIdenticalPairs(int[] A) {
        int res = 0, count[] = new int[101];
        for (int a: A) {
            res += count[a]++;
        }
        return res;
    } 
}