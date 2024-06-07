class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if(buckets==1) {
            return 0;
        }
            
        int digits = 1;
        int base = minutesToTest / minutesToDie + 1;
        int timer = base;
        while (buckets > timer) {
            timer *= base;
            digits += 1;
        }
        return digits;
    }
}