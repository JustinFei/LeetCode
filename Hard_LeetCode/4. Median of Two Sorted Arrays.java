class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int pa = (left + right) / 2;
            int pb = (m + n + 1) / 2 - pa;

            int maxLeftA = pa == 0 ? Integer.MIN_VALUE : nums1[pa - 1];
            int minRightA = pa == m ? Integer.MAX_VALUE : nums1[pa];
            int maxLeftB = pb == 0 ? Integer.MIN_VALUE : nums2[pb - 1];
            int minRightB = pb == n ? Integer.MAX_VALUE : nums2[pb];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = pa - 1;
            } else {
                left = pa + 1;
            }
        }

        return 0.0;
    }
}