public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] array = new int[triangle.size()+1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                array[j] = Math.min(array[j], array[j + 1]) + triangle.get(i).get(j);
            }
        }
        return array[0];
    }
}