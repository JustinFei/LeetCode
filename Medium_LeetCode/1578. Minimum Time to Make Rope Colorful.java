/*

    Intuition
    For a group of continuous same characters,
    we need to delete all the group but leave only one character.


    Explanation
    For each group of continuous same characters,
    we need cost = sum_cost(group) - max_cost(group)

*/

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = neededTime[0], curMax = neededTime[0];
        for (int i = 1; i < neededTime.length; i++) {
            if (colors.charAt(i) != colors.charAt(i - 1)) {
                res -= curMax;
                curMax = 0;
            }
            res += neededTime[i];
            curMax = Math.max(curMax, neededTime[i]);
        }

        res -= curMax;

        return res;
    }
}