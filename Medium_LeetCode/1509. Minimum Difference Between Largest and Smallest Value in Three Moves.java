class Solution {
	public int minDifference(int[] nums) {
		if (nums == null || nums.length <= 4) return 0;
		int n = nums.length;
		int[] array = Arrays.copyOf(nums, n);
		Arrays.sort(array);
		int res = array[n - 1] - array[0];

		for (int i = 0; i <= 3; i++)
		res = Math.min(res, array[n - (3 - i) - 1] - array[i]);
		return res;
	}
}