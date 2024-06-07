
class Solution { // O(n)
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;

				if (curEnd >= A.length - 1) {
					break;
				}
			}
		}
		return jumps;
    }
}
//-----------
class Solution { // O(n^ 2)
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else if (nums.length == 2) {
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((j == 0 || dp[j] != 0) && nums[j] >= i - j) {
                    if (dp[i] == 0) {
                        dp[i] = dp[j] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[nums.length - 1];
    }
}