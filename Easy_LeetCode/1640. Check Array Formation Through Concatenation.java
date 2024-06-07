class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        int i = 0;
        while (i < arr.length) {
            int[] cur = map.get(arr[i]);
            if (cur == null) {
                return false;
            } else {
                i++;
                for (int j = 1; j < cur.length; j++) {
                    if (arr[i++] != cur[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}