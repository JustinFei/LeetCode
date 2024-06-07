class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int left = 0;
        int i = start;
        int n = distance.length;
        while (i != destination) {
            if (i > 0) {
                left += distance[i - 1];
                i--;
            } else {
                left += distance[n - 1];
                i = n - 1;
            }
        }
        
        int right = 0;
        int j = start;
        while (j != destination) {
            right += distance[j];
            j++;
            if (j == n) j = 0;
        }
        return Math.min(left, right);
    }
}

// ---------------------------------
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;;
        }
        int res = 0, total = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                res += distance[i];
            }
            total += distance[i];
        }
        return Math.min(res, total - res);
    }
}