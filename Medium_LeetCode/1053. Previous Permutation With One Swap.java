class Solution {
    public int[] prevPermOpt1(int[] arr) {
        if (arr.length <= 1) return arr;
        int idx = -1;
		// find the largest i such that arr[i] > arr[i + 1]
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i - 1] > arr[i]) {
                idx = i - 1;
                break;
            }
        }
		// the array already sorted, not smaller permutation
        if (idx == -1) return arr;
		// find the largest j such that arr[j] > arr[i], then swap them
        for (int i = arr.length - 1; i > idx; i--) {
			// the second check to skip duplicate numbers
            if (arr[idx] > arr[i] && arr[i - 1] != arr[i]) {
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }
        return arr;
    }
}