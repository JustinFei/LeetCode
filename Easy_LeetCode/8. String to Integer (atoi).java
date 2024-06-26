  if (str == null || str.length() == 0)
        return 0;//
    str = str.trim();
    char firstChar = str.charAt(0);
    int sign = 1, start = 0, len = str.length();
    long sum = 0;
    if (firstChar == '+') {
        sign = 1;
        start++;
    } else if (firstChar == '-') {
        sign = -1;
        start++;
    }
    for (int i = start; i < len; i++) {
        if (!Character.isDigit(str.charAt(i)))
            return (int) sum * sign;
        sum = sum * 10 + str.charAt(i) - '0';
        if (sign == 1 && sum > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
    }

    return (int) sum * sign;
    ------------------------------------------
    public class Solution {
    public int myAtoi(String str) {
        if (str.isEmpty())
            return 0;
        str = str.trim();
        int i = 0, ans = 0, sign = 1, len = str.length();
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '+' ? 1 : -1;
        for (; i < len; ++i) {
            int tmp = str.charAt(i) - '0';
            if (tmp < 0 || tmp > 9)
                break;
            if (ans > Integer.MAX_VALUE / 10
                    || (ans == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                ans = ans * 10 + tmp;
        }
        return sign * ans;
    }
}