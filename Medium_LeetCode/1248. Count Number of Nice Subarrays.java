class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0, count = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] % 2 == 1) {
                k--;
                count = 0;
            }

            while (k == 0) {
                k += nums[l++] % 2;
                count++;
            }
            res += count;
        }

        return res;
    }
}

// -----------------------

public int numberOfSubarrays(int[] nums, int k) {
  LinkedList<Integer> deq = new LinkedList();
  deq.add(-1);
  int res = 0;
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] % 2 == 1) 
        deq.add(i);
    if (deq.size() > k + 1) 
        deq.pop();
    if (deq.size() == k + 1) 
        res += deq.get(1) - deq.get(0);
  }
  return res;
}