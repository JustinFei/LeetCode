class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int track = 0;
        for (int i = 0; i < arr.length; i++) {
            track++;
            while (track < arr[i]) {
                count++;
                if (count == k) {
                    return track;
                }
                track++;
            }
        }
        
        return track + (k - count);
    }
}

//--------------------
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (arr[m] - m - 1 < k)
                l = m + 1;
            else
                r = m;
        }
        return l + k;
    }
}