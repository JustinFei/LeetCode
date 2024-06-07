class Solution {
    public int myAtoi(String str) {
      int i = 0, sign = 1, res = 0, len = str.length();
      while (i < len && str.charAt(i) == ' ') {
        i++;
      }
      if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
        sign = str.charAt(i++) == '-' ? -1 : 1;
      }
      for (; i < len; ++i) {
        int cur = str.charAt(i) - '0';
        if (cur < 0 || cur > 9) {
          break;
        }
        if (res > (Integer.MAX_VALUE - cur) / 10) {
          return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
          res = res * 10 + cur;
        }
      }
      return sign * res;
    }
}