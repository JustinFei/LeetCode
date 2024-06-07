class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int degree = 1;
        List<Integer> list = new ArrayList<>();
        for(int n: nums) {
            Integer tmp = hash.get(n);
            tmp = tmp == null ? 1 : tmp + 1;
            hash.put(n, tmp);
            if (tmp == degree) list.add(n);
            else if (tmp > degree) {
                degree = tmp;
                list = new ArrayList<Integer>();
                list.add(n);
            }
        }
        int res = Integer.MAX_VALUE;

        for(Integer num: list) {
            int left = 0;
            int right = nums.length - 1;
            while(nums[left] != num) left++;
            while(nums[right] != num) right--;
            res = Math.min(res, right - left + 1);
        }
        return res;
    }
}