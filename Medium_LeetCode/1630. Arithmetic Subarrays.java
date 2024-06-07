class Solution {
    public boolean check(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        int[] arr;
        for (int i = 0; i < l.length; i++) {
            arr = new int[r[i] - l[i] + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[l[i] + j];
            }

            res.add(check(arr));
        }

        return res;
    }
}

// ———————————————————————————————
class Solution {
    public boolean check(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for (int num: arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        if ((max - min) % (arr.length - 1) != 0) {
            return false;
        }

        int diff = (max - min) / (arr.length - 1);
        int cur = min + diff;

        while (cur < max) {
            if (!set.contains(cur)) {
                return false;
            }

            cur += diff;
        }

        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        int[] arr;
        for (int i = 0; i < l.length; i++) {
            arr = new int[r[i] - l[i] + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[l[i] + j];
            }

            res.add(check(arr));
        }

        return res;
    }
}