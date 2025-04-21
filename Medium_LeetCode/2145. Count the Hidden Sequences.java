
/*
    Explanation
    Assume we start with a = 0,
    continuously calculate the next value by difference.
    We only need to record the current value a, the max and the min value in this sequence.

    Now we need to put the sequence with range [min, max] into a range of [lower, upper].

    If upper - lower < max - min, no possible hidden sequences.
    If upper - lower == max - min, we have only 1 possible hidden sequences.
    If upper - lower == max - min + 1, we have 2 possible hidden sequences.
    If upper - lower == max - min + k, we have k + 1 possible hidden sequences.


*/


class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int x = 0, y = 0, cur = 0;
        for (int d : differences) {
            cur += d;
            x = Math.min(x, cur);
            y = Math.max(y, cur);
            if (y - x > upper - lower) {
                return 0;
            }
        }
        return (upper - lower) - (y - x) + 1;
    }
}