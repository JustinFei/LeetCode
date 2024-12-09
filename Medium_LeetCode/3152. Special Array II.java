class Solution {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        int[] prefix = new int[nums.length];
        prefix[0] = 0;

        for (int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i - 1] + (nums[i] % 2 == nums[i - 1] % 2 ? 1 : 0);

        int j = 0;
        for (int[] q : queries) {
            res[j++] = prefix[q[1]] - prefix[q[0]] == 0;
        }

        return res;
    }
}

// ------------------------------

class Solution {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        ArrayList<Integer> violatingIndices = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            // same parity, found violating index
            if (nums[i] % 2 == nums[i - 1] % 2) {
                violatingIndices.add(i);
            }
        }
        int i = 0;
        for (int[] q : queries)
            ans[i++] = !binarySearch(
                q[0] + 1,
                q[1],
                violatingIndices
            );
        

        return ans;
    }

    private boolean binarySearch(
        int start,
        int end,
        ArrayList<Integer> violatingIndices
    ) {
        int left = 0;
        int right = violatingIndices.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int violatingIndex = violatingIndices.get(mid);

            if (violatingIndex < start) {
                // check right half
                left = mid + 1;
            } else if (violatingIndex > end) {
                // check left half
                right = mid - 1;
            } else {
                // violatingIndex falls in between start and end
                return true;
            }
        }

        return false;
    }
}