class Solution {
    public int totalMoney(int n) {
        int res = 0, day = 0, monday = 1, cur = monday;
        while (n > 0) {
            n--;
            res += cur;
            cur++;
            day++;

            if (day == 7) {
                day = 0;
                monday++;
                cur = monday;
            }
        }

        return res;
    }
}

// --------------------------------------------------------

class Solution {
    public int totalMoney(int n) {
        int m = n / 7;  //(no.of full weeks)
        // first week  1 2 3 4 5 6 7 (sum is 28 i.e. 7*(i+3) if i=1)
        // second week  2 3 4 5 6 7 8 (sum is 35 i.e. 7*(i+3) if i=2)
        //.... so on
        int res = 0;

        //calculating full weeks
        for (int i = 1; i <= m; i++){
            res += 7 * (i + 3);
        }

        //calculating left days
        for (int i = 7 * m ; i < n; i++) {
            res += ++m;
        }

        return res;
    }
}