// Two pointer

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }
        
        return res;
    }
}

// -------------------------------------------------

// Binary search

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
        
            result = Math.max(result, Math.min(dist1, dist2));
        }
        
        return result;
    }
}

// -----------------------------------------------------

// TreeSet

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> treeset = new TreeSet<>();
        for (int heater : heaters) treeset.add(heater);
        int res = 0;
        for (int house : houses) {
            int dist1 = treeset.ceiling(house) == null ? Integer.MAX_VALUE : treeset.ceiling(house) - house; 
            int dist2 = treeset.floor(house) == null ? Integer.MAX_VALUE : house - treeset.floor(house); 
            res = Math.max(res, Math.min(dist1, dist2)); 
        }
        return res;
    }
}