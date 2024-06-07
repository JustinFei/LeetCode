class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, r = n - 1;
        while (r >= 1 && arr[r - 1] <= arr[r]) r--;
        
        int res = r;

        for (int l = 0; l < n - 1 && l < r; l++) {
            if (r == n || arr[l] <= arr[r])
                res = Math.min(res, r - l - 1);
            else 
                r++;
            
            if (arr[l] > arr[l + 1]) 
                break;
        }

        return res;
    }
}