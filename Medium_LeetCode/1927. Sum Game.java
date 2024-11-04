class Solution {
    public boolean sumGame(String num) {
        int diff = 0, qCount = 0, n = num.length();
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?')
                qCount++;
            else
                diff = diff - (num.charAt(i) - '0');
        }
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                qCount++;
                diff += 9;
            } else
                diff = diff + (num.charAt(i) - '0');
        }
        if (qCount % 2 == 1)
            return true;
        if (qCount == 0)
            return diff != 0;
        return diff != (qCount / 2) * 9;
    }
}

// -----------------------------------

class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        double res = 0;
        for (int i = 0; i < n; i++)
            res += (i < n / 2 ? 1 : -1) * (num.charAt(i) == '?' ? 4.5 : num.charAt(i) - '0');
        return res != 0;
    }
}