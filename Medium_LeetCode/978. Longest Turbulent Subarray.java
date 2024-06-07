class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        int c, anchor = 0;
        

        for (int i = 1; i < arr.length; i++) {
            c = Integer.compare(arr[i - 1], arr[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == arr.length - 1 || c * Integer.compare(arr[i], arr[i + 1]) != -1) {
                res = Math.max(res, i - anchor + 1);
                anchor = i;
            }
        }
        
        return res;
    }
}