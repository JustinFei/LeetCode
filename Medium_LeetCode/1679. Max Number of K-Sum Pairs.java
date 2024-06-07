class Solution { O(n) O(n)
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int n: nums) {
            Integer tmp = map.get(k - n);
            if (tmp == null || tmp == 0) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            } else {
                map.put(k -n, tmp - 1);
                res++;
            }
        }
        return res;
    }
}

//-----
class Solution {
    public int maxOperations(int[] nums, int k) {
	Arrays.sort(nums);
	int res = 0, i = 0, j = nums.length -1 ;
	while (i < j)
		if (nums[i] + nums[j] > k) j--;
		else if (nums[i] + nums[j] < k) i++;
		else {i++; j--; res++;}
	return res;
    }
}