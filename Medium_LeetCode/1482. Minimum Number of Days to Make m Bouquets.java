class Solution {

    // Return the number of maximum bouquets that can be made on day mid.
    private int getNumOfBouquets(int[] bloomDay, int mid, int k) {
        int numOfBouquets = 0;
        int count = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            // If the flower is bloomed, add to the set. Else reset the count.
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                numOfBouquets++;
                count = 0;
            }
        }

        return numOfBouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int start = 0;
        int end = 0;
        for (int day : bloomDay) {
            end = Math.max(end, day);
        }

        int minDays = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minDays;
    }
}

// -----------------------------------------------------------------------

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(((long) k * m) > bloomDay.length) return -1;
        int l = 1, r = 1000_000_000;
        while(l <= r) {
            int mid = l + ((r - l) / 2);
            if(helper(bloomDay, mid, m, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    boolean helper(int[] bloomDay, int day, int m, int k) {
        int i = 0;
        while(i < bloomDay.length && m > 0) {
            int c = 0;
            while(i < bloomDay.length) {
                if(bloomDay[i] <= day) {
                    c++;
                    if(c == k) {
                        m--;
                        break;
                    }
                } else {
                    break;
                }
                i++;
            }
            i++;
        }
        return m <= 0;
    }
}