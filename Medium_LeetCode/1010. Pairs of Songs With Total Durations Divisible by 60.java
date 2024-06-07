class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length <= 1) {
            return 0;
        }
        for (int i = 0; i < time.length; i++) {
            time[i] %= 60;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int t: time) {
            Integer cur = map.get(t == 0 ? 0 : 60 - t);
            if (cur != null) {
                res += cur;
            } 
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return res;
    }
}
// ----------------------

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }
}

//--------------------------
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length < 2) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
         for (int t : time) {
            int theOther = (60 - t % 60) % 60;
            res += map.getOrDefault(theOther, 0); // in current HashMap, get the number of songs that if adding t equals to a multiple of 60.
            map.put(t % 60, 1 + map.getOrDefault(t % 60, 0)); // update the number of t % 60.
        }
        return res;
    }
}