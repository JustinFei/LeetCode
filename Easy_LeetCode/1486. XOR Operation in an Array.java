class Solution { // O(n) O(n)
    public int xorOperation(int n, int start) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = start + 2 * i;
        }
        int res = array[0];
        for (int i = 1; i < n; i++) {
            res ^= array[i];
        }
        return res;
    }
}
//------------------
class Solution { // O(n) O(1)
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i=1; i<n; i++){
            res = res ^ (start + 2 * i);
            }
        return res;
    }
}