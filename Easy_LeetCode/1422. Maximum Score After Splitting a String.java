class Solution {
    public int maxScore(String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            ones += s.charAt(i) == '1' ? 1 : 0;
        }
        int res = 0;
        int zeros = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones--;
            } else {
                zeros++;
            }

            res = Math.max(res, zeros + ones);
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
