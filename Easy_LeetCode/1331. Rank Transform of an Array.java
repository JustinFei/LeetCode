class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] A = Arrays.copyOf(arr, arr.length);
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        for (int a: A) {
            map.putIfAbsent(a, map.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            A[i] = map.get(arr[i]);
        }
        return A;
    }
}