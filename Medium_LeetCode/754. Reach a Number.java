class Solution {
    public int reachNumber(int target) {
        int moves = 0;
        int sum = 0;
        target = Math.abs(target);
        while (sum < target || (sum-target) % 2 != 0) {
            moves++;
            sum += moves;
        }
        return moves;
    }
}

//-------------------------
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}