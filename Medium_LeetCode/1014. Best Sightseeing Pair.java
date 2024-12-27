
class Solution {

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;

        // The left score is initially just the value of the first element.
        int maxLeftScore = values[0];

        int maxScore = 0;

        for (int i = 1; i < n; i++) {
            int currentRightScore = values[i] - i;
            // Update the maximum score by combining the best left score so far with the current right score.
            maxScore = Math.max(maxScore, maxLeftScore + currentRightScore);

            int currentLeftScore = values[i] + i;
            // Update the maximum left score up to the current index.
            maxLeftScore = Math.max(maxLeftScore, currentLeftScore);
        }

        return maxScore;
    }
}

// ---------------------------------------

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE, left = values[0], right;
        for (int i = 1; i < values.length; i++) {
            right = values[i] - i;
            max = Math.max(max, left + right);
            left = Math.max(left, values[i] + i);
        }
        return max;
    }
}

// --------- O(n ^ 2) ----------------------

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i + 1; j < values.length; j++) {
                max = Math.max(max, values[i] + values[j] + i - j);
            }
        }
        return max;
    }
}