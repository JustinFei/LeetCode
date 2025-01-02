class Solution {
    public int maxScore(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0, res = 0;

        for (int i = 0; i < s.length(); i++)
            right += s.charAt(i) == '1' ? 1 : 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') left++;
            else right--;
            res = Math.max(left + right, res);
        }
        
        return res;
    }
}

// ———————————————————————————————

class Solution {
    public int maxScore(String s) {
        int ones = 0;
        int zeros = 0;
        int best = Integer.MIN_VALUE;

        // score = ZL + OR
        // score = ZL + OT - OL
        // OT is constant
        // ZL : zeros left, OR : ones right, OT : ones total
​
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeros++;
            }
            
            best = Math.max(best, zeros - ones);
        }
        
        if (s.charAt(s.length() - 1) == '1') {
            ones++;
        }
        
        return best + ones;
    }
}
