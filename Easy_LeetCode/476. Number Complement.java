public class Solution {
    public int findComplement(int num) {
        return num^((Integer.highestOneBit(num) << 1) - 1);
    }
}
//-------------------------------------------
class Solution {
    public int findComplement(int num) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (num == 0) {
                break;
            }
            if ((num & 1) == 0) {
                res ^= 1 << i;
            }
            num >>= 1;
        }
        return res;
    }
}