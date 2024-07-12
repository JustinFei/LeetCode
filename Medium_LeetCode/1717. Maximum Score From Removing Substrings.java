class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder sb = new StringBuilder(s);
        if (x > y) {
            return remove(sb, "ab", x) + remove(sb, "ba", y);
        }
        return remove(sb, "ba", y) + remove(sb, "ab", x);
    }
    
    private int remove(StringBuilder sb, String pattern, int point) {
        int i = 0, res = 0;
        for (int j = 0; j < sb.length(); j++) {
            sb.setCharAt(i++, sb.charAt(j));
            if (i > 1 && sb.charAt(i - 2) == pattern.charAt(0) && sb.charAt(i - 1) == pattern.charAt(1)) {
                i -= 2;
                res += point;
            }
        }
        sb.setLength(i);
        return res;
    }
}

// -------------------------------------------------------------------------

class Solution {

    public int maximumGain(String s, int x, int y) {
        // Ensure "ab" always has higher points than "ba"
        if (x < y) {
            // Swap points
            int temp = x;
            x = y;
            y = temp;
            // Reverse the string to maintain logic
            s = new StringBuilder(s).reverse().toString();
        }

        int aCount = 0, bCount = 0, totalPoints = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'a') {
                aCount++;
            } else if (currentChar == 'b') {
                if (aCount > 0) {
                    // Can form "ab", remove it and add points
                    aCount--;
                    totalPoints += x;
                } else {
                    // Can't form "ab", keep 'b' for potential future "ba"
                    bCount++;
                }
            } else {
                // Non 'a' or 'b' character encountered
                // Calculate points for any remaining "ba" pairs
                totalPoints += Math.min(bCount, aCount) * y;
                // Reset counters for next segment
                aCount = bCount = 0;
            }
        }

        // Calculate points for any remaining "ba" pairs at the end
        totalPoints += Math.min(bCount, aCount) * y;

        return totalPoints;
    }
}