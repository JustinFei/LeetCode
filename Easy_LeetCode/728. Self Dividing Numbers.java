class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSDN(i))
                res.add(i);
        }
        return res;
    }
    
    private boolean isSDN(int num) {
        int tmp = num;
        while (tmp > 0) {
            int digit = tmp % 10;
            if (digit == 0) {
                return false;
            }
            else if (num % digit != 0) {
                return false;
            }
            tmp /= 10;
        }
        return true;
    }
}