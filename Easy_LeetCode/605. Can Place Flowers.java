class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        int cur = 1;
        for (int f: flowerbed) {
            if (f == 0) {
                cur++;
            } else {
                res += (cur - 1) / 2;  
                cur = 0;
            }
        }
        if (cur != 0) {
            res += cur / 2;
        }
        return res >= n; 
    }
}
//---------------------------------------------------------
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
             if(count>=n) {
                 return true;
             }
            i++;
        }
        return false;
    }
}
