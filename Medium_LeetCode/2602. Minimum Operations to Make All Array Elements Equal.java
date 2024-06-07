/*
    Approach

    To find smaller numbers than query[i] we can sort the array and use binary search
    Binary search over sorted nums to find index of query[i]
    Then use prefix sums to find sum of number in smaller and larger segments
    prefix[n] - prefix[i] is sum of numbers greater than or equal to query[i]
    prefix[i] is sum of numbers smaller than query[i]
    query[i] * i - prefix[i] is increments required
    prefix[n] - prefix[i] - query[i] * (n - i) is decrements required
    Total = query[i] * i - prefix[i] + prefix[n] - prefix[i] - query[i] * (n - i)
    Can be simplified to query[i] * (2 * i - n) + prefix[n] - 2 * prefix[i]

    Complexity
    
    Time complexity: O((n + m) * log(n))

    Space complexity: O(n)

*/


class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Long> ans = new ArrayList<>();
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++)
            prefix[i] = prefix[i - 1] + nums[i - 1];
        for (int x: queries) {
            int i = bisect_left(nums, x);
            ans.add(1L * x * (2 * i - n) + prefix[n] - 2 * prefix[i]);
        }
        return ans;
    }
    private int bisect_left(int[] nums, int x) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < x) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

// -----------------------------------------------------------

public List<Long> minOperations(int[] nums, int[] queries) {
    Arrays.sort(nums);
    List<Long> ans = new ArrayList<>();
    int n = nums.length;
    long[] prefix = new long[n + 1];
    for (int i = 1; i <= n; i++)
        prefix[i] = prefix[i - 1] + nums[i - 1];
    for (int x: queries) {
        int i = Arrays.binarySearch(nums, x);
        if (i < 0) i = -(i + 1); // convert negative index to insertion point
        ans.add(1L * x * (2 * i - n) + prefix[n] - 2 * prefix[i]);
    }
    return ans;
}